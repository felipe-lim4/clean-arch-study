package com.cleanarq.project.infra.config;

import com.cleanarq.project.application.useCase.DocumentCreate;
import com.cleanarq.project.application.useCase.DocumentList;

import com.cleanarq.project.domain.document.port.DocumentExtractText;
import com.cleanarq.project.domain.document.port.DocumentPersistence;
import com.cleanarq.project.domain.document.port.DocumentQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentConfig {

    @Bean
    public DocumentCreate documentCreateService(DocumentExtractText documentExtractText,  DocumentPersistence documentPersistence) {
        return new DocumentCreate(documentExtractText, documentPersistence);
    }

    @Bean
    public DocumentList documentListService(DocumentQuery documentQuery) {
        return new DocumentList(documentQuery);
    }
}
