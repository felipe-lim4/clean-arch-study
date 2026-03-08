package com.cleanarq.project.application.useCase;

import com.cleanarq.project.domain.document.entity.Document;
import com.cleanarq.project.domain.document.port.DocumentExtractText;
import com.cleanarq.project.domain.document.port.DocumentPersistence;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;



public class DocumentCreate {

    private final DocumentExtractText documentExtractText;
    private final DocumentPersistence documentPersistence;

    public DocumentCreate(DocumentExtractText documentExtractText, DocumentPersistence documentPersistence) {
        this.documentExtractText = documentExtractText;
        this.documentPersistence = documentPersistence;
    }

    public Document execute(InputStream file, String fileName) throws IOException {
        String content = documentExtractText.extractTextInputStream(file);
        Document document = new Document(fileName, content);
        return documentPersistence.SaveDocument(document);
    }
}
