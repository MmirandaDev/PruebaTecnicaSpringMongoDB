package com.promerica.test.controller;

import com.promerica.test.controller.behavior.IDocumentController;
import com.promerica.test.data.document.Documents;
import com.promerica.test.data.model.DocumentRequest;
import com.promerica.test.service.behavior.DocumentService;
import com.promerica.test.service.behavior.SequenceGeneratorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/documents")
public class DocumentController implements IDocumentController {
    private static final Logger log = Logger.getLogger(DocumentController.class.getName());

    @NonNull
    private final DocumentService documentService;

    @NonNull
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(documentService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Documents find(Long id) {
        return documentService.get(id);
    }

    @Override
    public ResponseEntity<?> save(DocumentRequest document) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Documents obj = modelMapper.map(document, Documents.class);

            obj.setId(sequenceGeneratorService.getSequenceNumber(Documents.SEQUENCE_NAME));
            documentService.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } catch (Exception e) {
            log.warning(e.getCause().toString());
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> update(DocumentRequest document) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Documents obj = modelMapper.map(document, Documents.class);
            documentService.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } catch (Exception e) {
            log.warning(e.getCause().toString());
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        try {
            Documents obj = documentService.get(id);
            if (obj != null) {
                documentService.delete(id);
                return new ResponseEntity<>(obj, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
