package com.cleanarq.project.domain.document.port;

import java.util.List;
import java.util.UUID;

public interface DocumentUpload {
    public void upload(UUID id, String title, List<String> content);
}
