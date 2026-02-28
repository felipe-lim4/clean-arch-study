package com.cleanarq.project.domain.document.port;

import com.cleanarq.project.domain.document.entity.Document;

public interface DocumentPersistence {
    public Document SaveDocument (Document document);
}
