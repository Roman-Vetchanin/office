package com.postal.office.service.impl;

import com.postal.office.model.PostalItem;
import com.postal.office.model.RegistrationAndMovementOfPostalItems;
import com.postal.office.repository.PostalItemRepository;
import com.postal.office.repository.RegistrationAndMovementOfPostalItemsRepository;
import com.postal.office.service.PostalStatusAndStatService;
import com.postal.office.service.TransportationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostalStatusAndStatServiceImpl implements PostalStatusAndStatService {

    private final RegistrationAndMovementOfPostalItemsRepository registrationAndMovementOfPostalItemsRepository;
    private final TransportationService transportationService;
    private final PostalItemRepository postalItemRepository;

    public PostalStatusAndStatServiceImpl(RegistrationAndMovementOfPostalItemsRepository registrationAndMovementOfPostalItemsRepository, TransportationService transportationService,
                                          PostalItemRepository postalItemRepository) {
        this.registrationAndMovementOfPostalItemsRepository = registrationAndMovementOfPostalItemsRepository;
        this.transportationService = transportationService;
        this.postalItemRepository = postalItemRepository;
    }

    @Override
    public PostalItem postalStatus(Long postalItemId) {
        PostalItem postalItem = postalItemRepository.findByPostalItemId(postalItemId);
        postalItem.setStatus(true);
        postalItemRepository.save(postalItem);
        return postalItem;
    }

    @Override
    public List<RegistrationAndMovementOfPostalItems> stat(Long postalItemId) {
        return registrationAndMovementOfPostalItemsRepository.findAllByPostalItem_PostalItemId(postalItemId);

    }
}
