package com.promerica.test.data.repository;

import com.promerica.test.data.document.Documents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Documents, Long> {
}
