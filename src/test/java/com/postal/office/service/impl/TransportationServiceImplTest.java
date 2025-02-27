package com.postal.office.service.impl;

import com.postal.office.repository.PostalOfficeRepository;
import com.postal.office.repository.RegistrationAndMovementOfPostalItemsRepository;
import com.postal.office.service.TransportationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TransportationServiceImplTest {
    @Mock
    private RegistrationAndMovementOfPostalItemsRepository registrationAndMovementOfPostalItemsRepository;
    @Mock
    private PostalOfficeRepository postalOfficeRepository;
    @InjectMocks
    private TransportationService transportationService;

    @Test
    void findPostalOfficeByIndex() {
    }

    @Test
    void departurePostalOffice() {
    }

    @Test
    void arrivalPostalOffice() {
    }
}