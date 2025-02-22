package com.postal.office.controller;

import com.postal.office.model.PostalItem;
import com.postal.office.model.RegistrationAndMovementOfPostalItems;
import com.postal.office.service.PostalStatusAndStatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stat")
public class PostalStatusAndStatController {
    private final PostalStatusAndStatService postalStatusAndStatService;

    public PostalStatusAndStatController(PostalStatusAndStatService postalStatusAndStatService) {
        this.postalStatusAndStatService = postalStatusAndStatService;
    }

    @PutMapping(value = "/status", params = "postalItemId")
    public ResponseEntity<PostalItem> postalStratus(@RequestParam Long postalItemId) {
        return ResponseEntity.ok(postalStatusAndStatService.postalStatus(postalItemId));
    }

    @GetMapping("/stat")
    public ResponseEntity<List<RegistrationAndMovementOfPostalItems>> stat(@RequestParam Long postalItemId) {
        return ResponseEntity.ok(postalStatusAndStatService.stat(postalItemId));
    }
}
