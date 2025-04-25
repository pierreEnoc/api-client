package com.client.api.services.impl;

import com.client.api.model.SubscriptionType;
import com.client.api.repository.SubscriptionTypeRepository;
import com.client.api.services.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;
    SubscriptionTypeServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }


    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType fidById(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);
        return optionalSubscriptionType.orElse(null);
    }

    @Override
    public SubscriptionType create(SubscriptionType subscriptionType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
