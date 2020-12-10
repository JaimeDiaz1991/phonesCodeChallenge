package org.jaimediaz1991.phonechallenge.phone.controller;

import java.util.List;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.phone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/phones")
    public ResponseEntity<List<PhoneResponse>> getAll() {
        return ResponseEntity.ok(phoneService.findAll());
    }

}
