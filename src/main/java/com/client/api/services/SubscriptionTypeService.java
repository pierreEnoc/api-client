package com.client.api.services;

import com.client.api.dto.SubscriptionTypeDto;
import com.client.api.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();
    SubscriptionType fidById(Long id);
    SubscriptionType create(SubscriptionTypeDto dto);
    SubscriptionType update(Long id, SubscriptionTypeDto dto);
    void delete(Long id);
}
