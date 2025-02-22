package com.postal.office.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RegistrationAndMovementOfPostalItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime registrationDate;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    @ManyToOne
    @JoinColumn(name = "postalItemId")
    private PostalItem postalItem;
    @ManyToOne
    @JoinColumn(name = "officeIndex")
    private PostalOffice postalOffice;

    public Long getId() {
        return id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public PostalItem getPostalItem() {
        return postalItem;
    }

    public PostalOffice getPostalOffice() {
        return postalOffice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public void setPostalItem(PostalItem postalItem) {
        this.postalItem = postalItem;
    }

    public void setPostalOffice(PostalOffice postalOffice) {
        this.postalOffice = postalOffice;
    }
}
