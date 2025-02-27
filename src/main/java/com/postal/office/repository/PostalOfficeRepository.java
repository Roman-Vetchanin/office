package com.postal.office.repository;

import com.postal.office.model.PostalOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostalOfficeRepository extends JpaRepository<PostalOffice, Long> {
    PostalOffice findPostalOfficeByOfficeIndex(Long officeIndex);
}