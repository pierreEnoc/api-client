package com.client.api.services;

import com.client.api.dto.UserDto;
import com.client.api.model.User;
import com.client.api.model.UserType;

import java.util.List;

public interface UserService {
  User create(UserDto userDto);

  List<UserType> findAll();
}
