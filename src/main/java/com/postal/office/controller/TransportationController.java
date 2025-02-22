package com.postal.office.controller;

import com.postal.office.model.PostalItem;
import com.postal.office.model.PostalOffice;
import com.postal.office.service.TransportationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movement")
public class TransportationController {

    private final TransportationService transportationService;

    public TransportationController(TransportationService transportationService) {
        this.transportationService = transportationService;
    }

//    @PutMapping("/arrival")
//    public ResponseEntity<PostalItem> arrival(@RequestParam Long postalItemId) {
//        return ResponseEntity.ok(transportationService.arrivalPostalOffice(postalItemId));
//    }
//    @PutMapping("/departure")
//    public ResponseEntity<PostalItem> departure(@RequestParam Long postalItemId) {
//        return ResponseEntity.ok(transportationService.departurePostalOffice(postalItemId));
//    }
    @PutMapping("/departure")
    public ResponseEntity<PostalItem> departurePostalOffice(@RequestParam Long postalItemId, @RequestParam Long postOfficeId) {
        return ResponseEntity.ok(transportationService.departurePostalOffice(postalItemId, postOfficeId));
    }
    @PutMapping("/arrival")
    public ResponseEntity<PostalItem> arrivalPostalOffice(@RequestParam Long postalItemId, @RequestParam Long postOfficeId) {
        return ResponseEntity.ok(transportationService.arrivalPostalOffice(postalItemId, postOfficeId));
    }

    @GetMapping("/getPostalOffice")
    public ResponseEntity<PostalOffice> getPostalOffice(@RequestParam Long postalOfficeIndex) {
        return ResponseEntity.ok(transportationService.findPostalOfficeByIndex(postalOfficeIndex));
    }
}
