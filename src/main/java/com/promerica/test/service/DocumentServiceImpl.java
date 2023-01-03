package com.promerica.test.service;

import com.promerica.test.data.document.Documents;
import com.promerica.test.data.repository.DocumentRepository;
import com.promerica.test.service.behavior.DocumentService;
import com.promerica.test.utility.GenericServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl extends GenericServiceImpl<Documents, Long> implements DocumentService {

    @NonNull
    private final DocumentRepository documentRepository;

    @Override
    public CrudRepository<Documents, Long> getDao() {
        return documentRepository;
    }

    @Override
    public Optional<Documents> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }
}