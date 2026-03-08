package com.cleanarq.project.infra.persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Document")
public class DocumentJpa {
    @Id
    @Column(nullable = false, unique = true)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String content;

    public DocumentJpa() {
    }

    public DocumentJpa(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
