package com.postal.office.service.impl;

import com.postal.office.exception.OfficeNotFoundException;
import com.postal.office.exception.PostalItemNotFoundException;
import com.postal.office.model.PostalItem;
import com.postal.office.model.PostalOffice;
import com.postal.office.model.RegistrationAndMovementOfPostalItems;
import com.postal.office.repository.PostalOfficeRepository;
import com.postal.office.repository.RegistrationAndMovementOfPostalItemsRepository;
import com.postal.office.service.TransportationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransportationServiceImpl implements TransportationService {

    private final RegistrationAndMovementOfPostalItemsRepository registrationAndMovementOfPostalItemsRepository;
    private final PostalOfficeRepository postalOfficeRepository;

    public TransportationServiceImpl(RegistrationAndMovementOfPostalItemsRepository registrationAndMovementOfPostalItemsRepository, PostalOfficeRepository postalOfficeRepository) {
        this.registrationAndMovementOfPostalItemsRepository =
                registrationAndMovementOfPostalItemsRepository;
        this.postalOfficeRepository = postalOfficeRepository;
    }

//    @Override
//    public PostalItem arrivalPostalOffice(Long postalItemId) {
//        RegistrationAndMovementOfPostalItems postalItem = postalItemGetByPostalItemId(postalItemId);
//        RegistrationAndMovementOfPostalItems newPostalItem = new RegistrationAndMovementOfPostalItems();
//        newPostalItem.setPostalItem(postalItem.getPostalItem());
//        newPostalItem.setPostalOffice(postalItem.getPostalOffice());
//        newPostalItem.setDepartureDate(postalItem.getDepartureDate());
//        newPostalItem.setRegistrationDate(postalItem.getRegistrationDate());
//        newPostalItem.setPostalItem(postalItem.getPostalItem());
//        postalItem.setArrivalDate(LocalDateTime.now());
//        registrationAndMovementOfPostalItemsRepository.save(postalItem);
//        return newPostalItem.getPostalItem();
//    }
//
//    @Override
//    public PostalItem departurePostalOffice(Long postalItemId) {
//        RegistrationAndMovementOfPostalItems postalItem = postalItemGetByPostalItemId(postalItemId);
//        RegistrationAndMovementOfPostalItems newPostalItem = new RegistrationAndMovementOfPostalItems();
//        newPostalItem.setDepartureDate(LocalDateTime.now());
//        newPostalItem.setPostalItem(postalItem.getPostalItem());
//        newPostalItem.setPostalOffice(postalItem.getPostalOffice());
//        newPostalItem.setArrivalDate(postalItem.getArrivalDate());
//        newPostalItem.setRegistrationDate(postalItem.getRegistrationDate());
//        newPostalItem.setPostalItem(postalItem.getPostalItem());
//        registrationAndMovementOfPostalItemsRepository.save(newPostalItem);
//        return newPostalItem.getPostalItem();
//    }

    private RegistrationAndMovementOfPostalItems postalItemGetByPostalItemId(Long postalItemId) {
        return registrationAndMovementOfPostalItemsRepository.
                findByPostalItem_PostalItemId(postalItemId);
    }
    @Override
    public PostalOffice findPostalOfficeByIndex(Long postalOfficeIndex) {
        return postalOfficeRepository.findByOfficeIndex(postalOfficeIndex);
    }
    @Override
    public PostalItem departurePostalOffice(Long postalItemId, Long postalOfficeIndex) {
        PostalOffice postalOffice = findPostalOfficeByIndex(postalOfficeIndex);
        RegistrationAndMovementOfPostalItems postalItem = postalItemGetByPostalItemId(postalItemId);
        RegistrationAndMovementOfPostalItems newPostalItem = new RegistrationAndMovementOfPostalItems();
        newPostalItem.setDepartureDate(LocalDateTime.now());
        newPostalItem.setPostalItem(postalItem.getPostalItem());
        newPostalItem.setPostalOffice(postalOffice);
        newPostalItem.setArrivalDate(postalItem.getArrivalDate());
        newPostalItem.setRegistrationDate(postalItem.getRegistrationDate());
        newPostalItem.setPostalItem(postalItem.getPostalItem());
        registrationAndMovementOfPostalItemsRepository.save(newPostalItem);
        return newPostalItem.getPostalItem();
    }
    @Override
    public PostalItem arrivalPostalOffice(Long postalItemId, Long postalOfficeIndex) {
        PostalOffice postalOffice = postalOfficeRepository.findByOfficeIndex(postalOfficeIndex);
        RegistrationAndMovementOfPostalItems postalItem = postalItemGetByPostalItemId(postalItemId);
        RegistrationAndMovementOfPostalItems newPostalItem = new RegistrationAndMovementOfPostalItems();
        newPostalItem.setPostalItem(postalItem.getPostalItem());
        newPostalItem.setPostalOffice(postalOffice);
        newPostalItem.setDepartureDate(postalItem.getDepartureDate());
        newPostalItem.setRegistrationDate(postalItem.getRegistrationDate());
        newPostalItem.setPostalItem(postalItem.getPostalItem());
        postalItem.setArrivalDate(LocalDateTime.now());
        registrationAndMovementOfPostalItemsRepository.save(newPostalItem);
        return newPostalItem.getPostalItem();
    }
}
