package com.cleanarq.project.domain.document.port;
import java.io.InputStream;
import java.io.IOException;

public interface DocumentExtractText {
    String extractTextInputStream (InputStream stream) throws IOException;

}
