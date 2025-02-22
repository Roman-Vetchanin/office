package com.postal.office.model.dto;

import com.postal.office.model.PostalItem;
import com.postal.office.model.Type;


/**
 * DTO for {@link PostalItem}
 */

public class PostalItemDto {
    private String recipientName;
    private Type type;
    private Long indexRecipient;
    private String recipientAddress;

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
}