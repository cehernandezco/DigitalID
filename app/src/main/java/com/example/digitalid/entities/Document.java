package com.example.digitalid.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class Document implements Serializable {
    public static final String DOCUMENT_KEY = "document_key";
    public static final String DOCUMENT_ID = "document_id";

    public Long id;
    public String documentName;
    public String documentType;
    public String photoDocument;
    public Integer userId;

    public Document() {
    }

    public Document(Long id, String documentName, String documentType, String photoDocument, Integer userId) {
        this.id = id;
        this.documentName = documentName;
        this.documentType = documentType;
        this.photoDocument = photoDocument;
        this.userId = userId;
    }

    public static String getDocumentKey() {
        return DOCUMENT_KEY;
    }

    public static String getDocumentId() {
        return DOCUMENT_ID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPhotoDocument() {
        return photoDocument;
    }

    public void setPhotoDocument(String photoDocument) {
        this.photoDocument = photoDocument;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
