package com.promerica.test.service.behavior;

import com.promerica.test.data.document.Documents;
import com.promerica.test.utility.GenericServiceAPI;

import java.util.Optional;

public interface DocumentService extends GenericServiceAPI<Documents, Long> {
    Optional<Documents> getDocumentById(Long id);
}
