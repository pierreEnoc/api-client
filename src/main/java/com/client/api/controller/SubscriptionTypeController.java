package com.client.api.controller;

import com.client.api.dto.SubscriptionTypeDto;
import com.client.api.exception.NotFoundException;
import com.client.api.model.SubscriptionType;
import com.client.api.repository.SubscriptionTypeRepository;
import com.client.api.services.SubscriptionTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("id") Long id) {
           return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.fidById(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@Valid @RequestBody SubscriptionTypeDto dto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionType> update(@PathVariable("id") Long id, @RequestBody SubscriptionTypeDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        subscriptionTypeService.deleteById(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
