package com.client.api.controller;

import com.client.api.model.SubscriptionType;
import com.client.api.repository.SubscriptionTypeRepository;
import com.client.api.services.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        SubscriptionType subscriptionType = subscriptionTypeService.fidById(id);
        if(Objects.nonNull(subscriptionType)) {
            return ResponseEntity.status(HttpStatus.OK).body(subscriptionType);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
