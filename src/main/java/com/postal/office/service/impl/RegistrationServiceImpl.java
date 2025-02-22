package com.postal.office.service.impl;

import com.postal.office.exception.OfficeNotFoundException;
import com.postal.office.model.PostalItem;
import com.postal.office.model.PostalOffice;
import com.postal.office.model.RegistrationAndMovementOfPostalItems;
import com.postal.office.model.Type;
import com.postal.office.model.dto.PostalItemDto;
import com.postal.office.repository.PostalItemRepository;
import com.postal.office.repository.PostalOfficeRepository;
import com.postal.office.repository.RegistrationAndMovementOfPostalItemsRepository;
import com.postal.office.service.RegistrationService;
import jakarta.annotation.PostConstruct;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final Faker faker = new Faker();

    private final PostalItemRepository postalItemRepository;
    private final RegistrationAndMovementOfPostalItemsRepository registrationAndMovementOfPostalItemsRepository;
    private final PostalOfficeRepository postalOfficeRepository;

    public RegistrationServiceImpl(PostalItemRepository postalItemRepository, RegistrationAndMovementOfPostalItemsRepository registrationAndMovementOfPostalItemsRepository, PostalOfficeRepository postalOfficeRepository) {
        this.postalItemRepository = postalItemRepository;
        this.registrationAndMovementOfPostalItemsRepository = registrationAndMovementOfPostalItemsRepository;
        this.postalOfficeRepository = postalOfficeRepository;
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            PostalOffice postalOffice = new PostalOffice();
            postalOffice.setOfficeAddress(faker.address().streetAddress());
            postalOffice.setOfficeIndex(faker.random().nextLong());
            postalOffice.setOfficeName(faker.heyArnold().characters());
            postalOfficeRepository.save(postalOffice);
        }
    }

    @Override
    public PostalItem createAndRegistrationPostalItem(PostalItemDto postalItem, Long officeIndex) {
        PostalItem postalItemSaved = new PostalItem();
        postalItemSaved.setPostalItemId((long) postalItem.hashCode());
        postalItemSaved.setRecipientName(postalItem.getRecipientName());
        postalItemSaved.setType(postalItem.getType());
        postalItemSaved.setIndexRecipient(postalItem.getIndexRecipient());
        postalItemSaved.setRecipientAddress(postalItem.getRecipientAddress());
        postalItemSaved.setStatus(false);
        postalItemRepository.save(postalItemSaved);
        PostalOffice postalOfficeSaved = findPostalOfficeByOfficeIndex(officeIndex);
        registerOrMovePostalItem(postalItemSaved, postalOfficeSaved);
        return postalItemSaved;
    }
    public PostalOffice findPostalOfficeByOfficeIndex(Long officeIndex) {
        return postalOfficeRepository.
                findByOfficeIndex(officeIndex);
    }

    public void registerOrMovePostalItem(PostalItem postalItem, PostalOffice postalOffice) {
        RegistrationAndMovementOfPostalItems registrationAndMovementOfPostalItems =
                new RegistrationAndMovementOfPostalItems();
        registrationAndMovementOfPostalItems.setPostalItem(postalItem);
        registrationAndMovementOfPostalItems.setPostalOffice(postalOffice);
        registrationAndMovementOfPostalItems.setRegistrationDate(LocalDateTime.now());
        registrationAndMovementOfPostalItems.setArrivalDate(LocalDateTime.now());
        registrationAndMovementOfPostalItemsRepository.save(registrationAndMovementOfPostalItems);
    }
}
