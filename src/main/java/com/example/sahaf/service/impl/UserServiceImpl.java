package com.example.sahaf.service.impl;

import com.example.sahaf.convert.UserConverter;
import com.example.sahaf.dto.UserDto;
import com.example.sahaf.dto.UserPageableDto;
import com.example.sahaf.dto.UsersPageDto;
import com.example.sahaf.entities.User;
import com.example.sahaf.repository.UserRepository;
import com.example.sahaf.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userConverter.userDtoConvertToUser(userDto);

        user = userRepository.save(user);

        return userConverter.userConvertToUserDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userConverter::userConvertToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user= userConverter.userDtoConvertToUser(userDto);
        user=userRepository.save(user);
       return userConverter.userConvertToUserDto(user);
    }

    @Override
    public Boolean delete(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDto findById(int id) {

        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        UserDto userDto = new UserDto();
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }

    @Override
    public UsersPageDto getUsersList(int no, int size) {

        Pageable pageable = PageRequest.of(no, size);
        Page<User> usersPage = userRepository.findAll(pageable);

        List<UserPageableDto> userPageableDtos = new ArrayList<>();

        usersPage.toList().forEach(user -> {

            UserPageableDto userPageableDto = userConverter.userConvertToUserPageableDto(user);

            userPageableDtos.add(userPageableDto);

        });

        //List<UserPageableDto> collect = usersPage.toList().stream().map(this::userConvertToUserPageableDto).collect(Collectors.toList());

        UsersPageDto usersPageDto = new UsersPageDto();
        usersPageDto.setCount(userPageableDtos.size());
        usersPageDto.setUserPageableDtos(userPageableDtos);

        return usersPageDto;
    }
}
