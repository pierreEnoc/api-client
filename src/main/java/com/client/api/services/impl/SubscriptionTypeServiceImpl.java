package com.client.api.services.impl;

import com.client.api.dto.SubscriptionTypeDto;
import com.client.api.exception.BadRequestException;
import com.client.api.exception.NotFoundException;
import com.client.api.mapper.SubscriptionTypeMapper;
import com.client.api.model.SubscriptionType;
import com.client.api.repository.SubscriptionTypeRepository;
import com.client.api.services.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Objects;
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
       return getSubscriptionType(id);
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto subscriptionTypeDto) {
        if(Objects.nonNull(subscriptionTypeDto.getId())) {
            throw  new BadRequestException("Id não deve ser information");
        }
        return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(subscriptionTypeDto));
    }


    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
     getSubscriptionType(id);
     dto.setId(id);
     return subscriptionTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }


    @Override
    public void deleteById(Long id) {
        getSubscriptionType(id);
        subscriptionTypeRepository.deleteById(id);

    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);
        if (optionalSubscriptionType.isEmpty()) {
            throw  new NotFoundException("SubscriptionType não encontrado");
        }
        return optionalSubscriptionType.get();
    }
}
