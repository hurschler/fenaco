package com.fenaco.ua.tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.ToHTMLContentHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import com.fenaco.ua.ufarevue.model.Artikel;
import com.fenaco.ua.ufarevue.model.Ausgabe;
import com.fenaco.ua.ufarevue.model.Autor;
import com.fenaco.ua.ufarevue.model.Thema;

public class Tika {

    public static void main(String[] args) throws IOException, SAXException, TikaException {

        extractPdf(new Ausgabe(), "ufarevue/2018_3093855/D_UR0118_Composit.pdf");

    }

    public static void extractPdf(Ausgabe ausgabe, String fileName) throws IOException, SAXException, TikaException, FileNotFoundException {
        PDFParser pdfParser = new PDFParser();
        ContentHandler handler = new ToHTMLContentHandler();
        Metadata metadata = new Metadata();
        ParseContext contextParser = new ParseContext();
        Class<Tika> clazz = Tika.class;
        InputStream stream = new FileInputStream(new File(fileName));
        try (stream) {
            pdfParser.parse(stream, handler, metadata, contextParser);
            Document doc = Jsoup.parse(handler.toString());
            for (Node node : doc.body().childNodes()) {
                if (node.toString().length() > 50) {
                    Artikel artikel = new Artikel(ausgabe);
                    artikel.setText(Jsoup.parse(node.toString()).text());
                    artikel.setHtmlText(node.toString());
                    List<Node> autorList = new ArrayList<>();
                    autorList = node.childNodes().parallelStream().filter(r -> findAutor(r)).collect(Collectors.toList());
                    if (autorList.size() > 0) {
                        artikel.setAutor(new Autor(autorList.get(0)));
                    }
                    artikel.setThema(findThema(node));
                    ausgabe.addArtikel(artikel);
                }
            }
            FileOutputStream outputStream = new FileOutputStream(fileName + ".txt");
            byte[] strToBytes = handler.toString().getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        }
    }

    private static boolean findAutor(Node node) {
        if (node.toString().contains("Autor")) {
            return true;
        }
        return false;
    }

    private static String findThema(Node node) {
        List<Node> list = node.childNodes();
        List<String> listOfStrings = new ArrayList<>();
        list.forEach((Node nodeElement) -> listOfStrings.add(nodeElement.toString().toLowerCase()));
        String thema = "";
        if (list.size() > 3) {
            List<String> listOfThemasStrings = Stream.of(Thema.values()).map(Enum::name).collect(Collectors.toList());
            listOfThemasStrings.replaceAll(String::toLowerCase);
            Predicate<String> isIn2 = s -> listOfThemasStrings.stream().anyMatch(mc -> s.contains(mc));
            List<String> resultList = listOfStrings.stream().filter(isIn2).collect(Collectors.toList());
            if (resultList.size() > 0) {
                for (String s : listOfThemasStrings) {
                    if (resultList.get(0).contains(s)) {
                        thema = s;
                    }
                }
            }
        }
        return thema;
    }
}
