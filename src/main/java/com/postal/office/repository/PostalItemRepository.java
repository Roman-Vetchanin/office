package com.postal.office.repository;

import com.postal.office.model.PostalItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostalItemRepository extends JpaRepository<PostalItem, Long> {
    PostalItem findByPostalItemId(Long postalItemId);
}