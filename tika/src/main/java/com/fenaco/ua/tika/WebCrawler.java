package com.fenaco.ua.tika;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.HashSet;
import org.apache.tika.exception.TikaException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class WebCrawler extends Tika {

    private final HashSet<String> links;

    public WebCrawler() {
        links = new HashSet<>();
    }

    public void getPageLinks(String URL) {
        // 4. Check if you have already crawled the URLs
        // (we are intentionally not checking for duplicate content in this
        // example)
        if (!links.contains(URL)) {
            try {
                // 4. (i) If not add it to the index
                if (URL.contains("www.ufarevue.ch") || (URL.contains("www.ufarevue.ch"))) {
                    if (links.add(URL)) {
                        System.out.println(URL);
                    }
                }
                if (URL.equals("")) {
                    return;
                }
                // 2. Fetch the HTML code
                Document document = Jsoup.connect(URL).get();
                // 3. Parse the HTML to extract links to other URLs
                Elements linksOnPage = document.select("a[href]");

                // 5. For each extracted URL... go back to Step 4.
                String pageNameParteOne = URL.replace("https://www.ufarevue.ch/deu/", "");
                if (pageNameParteOne.indexOf(".shtml") == -1) {
                    return;
                }
                String pageName = pageNameParteOne.substring(0, pageNameParteOne.indexOf(".shtml"));
                new File("ufarevue/" + pageName).mkdir();
                for (Element page : linksOnPage) {
                    // System.out.println(page);
                    String href = page.attr("abs:href");
                    if (href.contains("pdf") && href.contains("www.ufarevue.ch")) {
                        System.out.println("pdf: " + href);
                        URL pdfUrl = new URL(href);
                        ReadableByteChannel readableByteChannel = Channels.newChannel(pdfUrl.openStream());
                        String fileName = "ufarevue/" + pageName + "/" + href.replace("https://www.ufarevue.ch/files/", "");
                        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                        FileChannel fileChannel = fileOutputStream.getChannel();
                        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                        try {
                            Tika.extractPdf(fileName);
                        } catch (SAXException | TikaException e) {
                            e.printStackTrace();
                        }

                    }
                    if (URL.contains("www.ufarevue.ch")) {
                        // getPageLinks(page.attr("abs:href"));
                    }
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // 1. Pick a URL from the frontier
        // new
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2019_3584603.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2018_3093855.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2017_2496349.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2016.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2015_1426236.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2014_924331.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/seite_seitenleiste267123_267123.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2012_24919.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2011_31796.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2010_31828.shtml");
        new WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/2008_31892.shtml");

        // new
        // WebCrawler().getPageLinks("https://www.ufarevue.ch/deu/printausgaben.shtml");
    }
}
