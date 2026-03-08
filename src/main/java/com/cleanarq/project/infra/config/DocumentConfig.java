package com.cleanarq.project.infra.config;

import com.cleanarq.project.application.useCase.DocumentCreate;
import com.cleanarq.project.domain.document.port.DocumentExtractText;
import com.cleanarq.project.domain.document.port.DocumentPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentConfig {

    @Bean
    public DocumentCreate documentCreateService(DocumentExtractText documentExtractText,  DocumentPersistence documentPersistence) {
        return new DocumentCreate(documentExtractText, documentPersistence);
    }
}
