package com.cleanarq.project.application.useCase;

import com.cleanarq.project.application.dto.ResDto.ResDocumentsDto;
import com.cleanarq.project.application.useCase.exceptions.NenhumDocumentoException;
import com.cleanarq.project.domain.document.entity.Document;
import com.cleanarq.project.domain.document.port.DocumentQuery;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentList {

    private final DocumentQuery documentQuery;

    public DocumentList(DocumentQuery documentQuery) {
        this.documentQuery = documentQuery;
    }

    public ResDocumentsDto getDocuments() {
        List<Document> documents = documentQuery.getDocuments();
        if (documents.isEmpty()) {
            throw new NenhumDocumentoException("Nenhum documento foi encontrado.");
        }

        List<String> listDocumentsName = documents.stream()
                .map(Document::getTitle)
                .collect(Collectors.toList());

        return new ResDocumentsDto(listDocumentsName);
    }
}
