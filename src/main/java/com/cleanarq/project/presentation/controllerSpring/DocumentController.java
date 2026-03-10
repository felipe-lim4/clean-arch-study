package com.cleanarq.project.presentation.controllerSpring;

import com.cleanarq.project.application.dto.ResDto.ResDocumentDto;
import com.cleanarq.project.application.dto.ResDto.ResDocumentsDto;
import com.cleanarq.project.application.useCase.DocumentCreate;
import com.cleanarq.project.application.useCase.DocumentList;
import com.cleanarq.project.application.useCase.exceptions.NenhumDocumentoException;
import com.cleanarq.project.domain.document.entity.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentCreate documentCreateService;
    private final DocumentList documentListService;

    public DocumentController(DocumentCreate documentCreateService, DocumentList documentListService) {
        this.documentCreateService = documentCreateService;
        this.documentListService = documentListService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResDocumentDto> upload(@RequestParam MultipartFile file){

        String fileName = file.getOriginalFilename();
        InputStream inputStream = null;
        try{
            inputStream = file.getInputStream();
        }catch(IOException e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        try{
            Document document = documentCreateService.execute(inputStream, fileName);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResDocumentDto(document.getTitle(), document.getContent()));
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping("/list-documents")
    public ResponseEntity<ResDocumentsDto> getListDocuments(){
        ResDocumentsDto documents;
        try {
            documents = documentListService.getDocuments();
        } catch (NenhumDocumentoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }
}
