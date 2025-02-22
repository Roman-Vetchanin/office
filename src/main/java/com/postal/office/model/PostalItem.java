package com.postal.office.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class PostalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postalItemId;
    private String recipientName;
    private Type type;
    private Long indexRecipient;
    private String recipientAddress;
    private Boolean status;

    public Long getId() {
        return id;
    }

    public Long getPostalItemId() {
        return postalItemId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public Type getType() {
        return type;
    }

    public Long getIndexRecipient() {
        return indexRecipient;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPostalItemId(Long postalItemId) {
        this.postalItemId = postalItemId;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setIndexRecipient(Long indexRecipient) {
        this.indexRecipient = indexRecipient;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
