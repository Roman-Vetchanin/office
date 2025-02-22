package com.postal.office.service;

import com.postal.office.model.PostalItem;
import com.postal.office.model.PostalOffice;
import com.postal.office.model.RegistrationAndMovementOfPostalItems;

public interface TransportationService {
//    PostalItem arrivalPostalOffice(Long postalItemId);
//
//    PostalItem departurePostalOffice(Long postalItemId);

    //    RegistrationAndMovementOfPostalItems postalItemGetByPostalItemId(Long postalItemId);
    PostalOffice findPostalOfficeByIndex(Long postalOfficeIndex);

    PostalItem departurePostalOffice(Long postalItemId, Long postalOfficeIndex);

    PostalItem arrivalPostalOffice(Long postalItemId, Long postalOfficeIndex);
}
