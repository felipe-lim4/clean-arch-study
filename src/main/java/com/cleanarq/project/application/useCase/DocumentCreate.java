package com.cleanarq.project.application.useCase;

import com.cleanarq.project.domain.document.entity.Document;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;


public class DocumentCreate {

    public Document execute(InputStream file, String fileName) {

        Document document = null;
        try{
            byte[] fileBytes =file.readAllBytes();
            String content = new String(fileBytes, StandardCharsets.UTF_8);
           document = new Document(fileName, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return document;
    }
}
