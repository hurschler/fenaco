package com.fenaco.ua.ufarevue;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.xml.sax.SAXException;
import com.fenaco.ua.tika.Tika;
import com.fenaco.ua.ufarevue.model.Ausgabe;
import com.fenaco.ua.ufarevue.model.AusgabeRepository;

@SpringBootApplication
@EnableJpaAuditing
public class Application implements CommandLineRunner {

    @Autowired
    AusgabeRepository ausgabeRepo;

    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, TikaException {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws FileNotFoundException, IOException, SAXException, TikaException {
        Ausgabe ausgabe = new Ausgabe();
        ausgabe.setBezeichnung("D_UR0118_Composit.pdf");
        ausgabe.setJahr("2018");
        ausgabe.setSprache("de");
        Tika.extractPdf(ausgabe, "ufarevue/2018_3093855/D_UR0118_Composit.pdf");
        ausgabeRepo.save(ausgabe);
    }
}
