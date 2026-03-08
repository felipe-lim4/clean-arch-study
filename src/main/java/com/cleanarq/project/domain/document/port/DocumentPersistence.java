package com.cleanarq.project.domain.document.port;

import com.cleanarq.project.domain.document.entity.Document;

public interface DocumentPersistence {
    Document SaveDocument (Document document);
}
