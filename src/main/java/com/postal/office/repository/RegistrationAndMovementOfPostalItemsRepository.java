package com.postal.office.repository;

import com.postal.office.model.RegistrationAndMovementOfPostalItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationAndMovementOfPostalItemsRepository extends JpaRepository<RegistrationAndMovementOfPostalItems, Long> {
    List <RegistrationAndMovementOfPostalItems> findAllByPostalItem_PostalItemId(Long postalItemIndex);
    RegistrationAndMovementOfPostalItems findRegistrationAndMovementOfPostalItemsByPostalItem_PostalItemId(Long postalItemId);
}