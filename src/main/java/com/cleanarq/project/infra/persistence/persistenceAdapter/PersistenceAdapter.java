package com.cleanarq.project.infra.persistence.persistenceAdapter;

import com.cleanarq.project.domain.document.entity.Document;
import com.cleanarq.project.domain.document.port.DocumentPersistence;
import com.cleanarq.project.infra.persistence.Entity.DocumentJpa;
import com.cleanarq.project.infra.persistence.repository.DocumentJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersistenceAdapter implements DocumentPersistence {

    private final DocumentJpaRepository documentJpaRepository;

    public PersistenceAdapter(DocumentJpaRepository documentJpaRepository) {
        this.documentJpaRepository = documentJpaRepository;
    }

    @Override
    public Document SaveDocument(Document document) {

        DocumentJpa documentJpa = documentJpaRepository.save(
                new DocumentJpa(
                        document.getId(),
                        document.getTitle(),
                        document.getContent()));

        return new Document(
                documentJpa.getId(),
                documentJpa.getTitle(),
                documentJpa.getContent());
    }
}
