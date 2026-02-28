package com.cleanarq.project.domain.document.entity;

import java.util.List;
import java.util.UUID;

public class Document {
    private UUID id;
    private String title;
    private String content;


    public Document(UUID id, String title, String content) {
        validate(title, content);
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Document(String title, String content) {
        validate(title, content);
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
    }

    private void validate(String title, String content) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Titulo não pode ser nulo ou vazio");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Conteúdo não pode ser nulo ou vazio");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


}
