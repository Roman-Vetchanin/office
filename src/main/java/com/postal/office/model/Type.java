package com.postal.office.model;

public enum Type {
    LETTER ("Письмо"), PACKAGE("Посылка"), PARCEL_POST("Бандероль"), POSTCARD("Открытка");

    final String type;

    Type(String type) {
        this.type = type;
    }
}
