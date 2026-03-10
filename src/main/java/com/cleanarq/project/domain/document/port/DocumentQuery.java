package com.cleanarq.project.domain.document.port;

import com.cleanarq.project.domain.document.entity.Document;

import java.util.List;

public interface DocumentQuery {

    List<Document> getDocuments();
}
