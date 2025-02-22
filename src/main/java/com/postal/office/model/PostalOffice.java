package com.postal.office.model;

import jakarta.persistence.*;


@Entity
public class PostalOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "officeIndex")
    private Long officeIndex;
    private String officeName;
    private String officeAddress;

    public Long getId() {
        return id;
    }

    public Long getOfficeIndex() {
        return officeIndex;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOfficeIndex(Long officeIndex) {
        this.officeIndex = officeIndex;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}
