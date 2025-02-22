package com.postal.office.controller;

import com.postal.office.model.PostalItem;
import com.postal.office.model.dto.PostalItemDto;
import com.postal.office.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/{officeIndex}")
    public ResponseEntity <PostalItem> registration(@RequestBody PostalItemDto postalItemDto, @PathVariable Long officeIndex) {
        return ResponseEntity.ok(registrationService.createAndRegistrationPostalItem(postalItemDto, officeIndex));
    }
}
