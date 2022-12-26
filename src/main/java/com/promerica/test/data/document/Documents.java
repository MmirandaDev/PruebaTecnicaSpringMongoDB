package com.promerica.test.data.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "IdentityDocument")
public class Documents {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int id;
    private String identityDocument;
    private String number;
    private String expiryDate;
    private String emissionDate;
    private DocumentType documentType;
}
