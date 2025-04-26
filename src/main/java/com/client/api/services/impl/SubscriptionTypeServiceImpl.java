package com.client.api.services.impl;

import com.client.api.dto.SubscriptionTypeDto;
import com.client.api.exception.NotFoundException;
import com.client.api.model.SubscriptionType;
import com.client.api.repository.SubscriptionTypeRepository;
import com.client.api.services.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
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
        if (optionalSubscriptionType.isEmpty()) {
            throw  new NotFoundException("SubscriptionType não encontrado");
        }
       return optionalSubscriptionType.get();
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto subscriptionTypeDto) {
        return subscriptionTypeRepository.save(SubscriptionType.builder()
                .id(subscriptionTypeDto.getId())
                .name(subscriptionTypeDto.getName())
                .accessMonth(subscriptionTypeDto.getAccessMonth())
                .price(subscriptionTypeDto.getPrice())
                .productKey(subscriptionTypeDto.getProductKey())
                .build());
    }

    @Override
    public void delete(Long id) {

    }
}
