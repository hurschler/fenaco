package com.fenaco.ua.ibm.imagereco;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fenaco.ua.ibm.imagereco.model.ImageResult;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

@SpringBootApplication
public class ImageRecoApplication implements CommandLineRunner {

    private static final String APPLICATION_KEY = "blaaa-app-key";

    private static final String URL = "https://gateway.watsonplatform.net/visual-recognition/api";

    public static void main(String[] args) {
        SpringApplication.run(ImageRecoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        IamOptions options = new IamOptions.Builder().apiKey(APPLICATION_KEY).build();
        VisualRecognition service = new VisualRecognition("2018-03-19", options);
        InputStream imagesStream = new FileInputStream(new File("image/elefant.jpg"));
        ClassifyOptions classifyOptions = new ClassifyOptions.Builder() //
                .addClassifierId("default") //
                .imagesFile(imagesStream) //
                .imagesFilename("elefant.jpg") //
                .threshold((float) 0.6).owners(Arrays.asList("me")).build();
        ClassifiedImages result = service.classify(classifyOptions).execute();

        ObjectMapper mapper = new ObjectMapper();
        ImageResult imageResult = mapper.readValue(result.toString(), ImageResult.class);

        System.out.println(result);
    }

}
