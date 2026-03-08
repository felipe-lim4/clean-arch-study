package com.cleanarq.project.infra.pdfbox;

import com.cleanarq.project.domain.document.port.DocumentExtractText;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class PdfBoxAdapter implements DocumentExtractText {
    @Override
    public String extractTextInputStream(InputStream stream) {
        try {
            System.out.println("Extracting PDF...");
            PDDocument doc = Loader.loadPDF(stream.readAllBytes());
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            System.out.println(pdfTextStripper.getText(doc));
            return pdfTextStripper.getText(doc);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
