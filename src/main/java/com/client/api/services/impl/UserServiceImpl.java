package com.client.api.services.impl;

import com.client.api.dto.UserDto;
import com.client.api.exception.BadRequestException;
import com.client.api.exception.NotFoundException;
import com.client.api.mapper.UserMapper;
import com.client.api.model.User;
import com.client.api.model.UserType;
import com.client.api.repository.UserRepository;
import com.client.api.repository.UserTypeRepository;
import com.client.api.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    private final UserTypeRepository userTypeRepository;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public User create(UserDto userDto) {

        if(Objects.nonNull(userDto.getId())) {
            throw new BadRequestException("Id não deve ser nulo");
        }

        var uuserTypeOptional = userTypeRepository.findById(userDto.getUserTypeId());
        if (uuserTypeOptional.isEmpty()) {
            throw new NotFoundException("UserTypeId não encontrado");
        }
        UserType userType = uuserTypeOptional.get();
        User user = UserMapper.fromDtoToEntity(userDto,userType, null);

        return userRepository.save(user);
    }

    @Override
    public List <UserType> findAll() {
        return userTypeRepository.findAll();
    }

}
