package com.postal.office.service;

import com.postal.office.model.PostalItem;
import com.postal.office.model.RegistrationAndMovementOfPostalItems;

import java.util.List;

public interface PostalStatusAndStatService {
    PostalItem postalStatus(Long postalItemId);
    List<RegistrationAndMovementOfPostalItems> stat (Long postalItemId);
}
