package com.example.sahaf.service;

import com.example.sahaf.dto.UserDto;
import com.example.sahaf.dto.UsersPageDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    List<UserDto> findAll();

    UserDto updateUser(UserDto userDto);

    Boolean delete(int id);

    UserDto findById(int id);
    UsersPageDto getUsersList(int no, int size);
}
