package com.example.bajajHDC.controller;

import com.example.bajajHDC.model.DataRequest;
import com.example.bajajHDC.model.DataResponse;
import com.example.bajajHDC.service.bfhlservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class bfhlcontroller {

    private final bfhlservice bfhlservice;

    @Autowired
    public bfhlcontroller(bfhlservice bfhlservice) {
        this.bfhlservice = bfhlservice;
    }

    @GetMapping("/bfhl")
    public ResponseEntity<?> getOperationCode() {
        // Hardcoded response
        return ResponseEntity.ok().body("{\"operation_code\":1}");
    }

    @PostMapping("/bfhl")
    public ResponseEntity<?> handleData(@RequestBody DataRequest request) {
        // Process the request data and generate the response
        DataResponse response = bfhlservice.processData(request);
        return ResponseEntity.ok().body(response);
    }

}
