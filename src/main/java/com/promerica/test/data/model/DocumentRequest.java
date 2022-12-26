package com.promerica.test.data.model;

import com.promerica.test.data.document.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequest {
    private String id;
    private String identityDocument;
    private String number;
    private String expiryDate;
    private String emissionDate;
    private DocumentType documentType;
}
