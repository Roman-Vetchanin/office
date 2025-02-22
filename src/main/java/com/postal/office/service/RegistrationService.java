package com.postal.office.service;

import com.postal.office.model.PostalItem;
import com.postal.office.model.PostalOffice;
import com.postal.office.model.dto.PostalItemDto;

public interface RegistrationService {
    PostalItem createAndRegistrationPostalItem(PostalItemDto postalItem, Long officeIndex);

    void registerOrMovePostalItem(PostalItem postalItem, PostalOffice postalOffice);
}
