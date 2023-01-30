package com.example.sahaf.service.impl;

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

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
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
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UsersPageDto getUsersList(int no, int size) {

        Pageable pageable = PageRequest.of(no, size);
        Page<User> usersPage = userRepository.findAll(pageable);

        List<UserPageableDto> userPageableDtos = new ArrayList<>();

        usersPage.toList().forEach(user -> {
            UserPageableDto dto = new UserPageableDto();

            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setSurname(user.getSurname());
            dto.setPhoneNumber(user.getPhoneNumber());

            userPageableDtos.add(dto);

        });
        UsersPageDto usersPageDto = new UsersPageDto();
        usersPageDto.setCount(userPageableDtos.size());
        usersPageDto.setUserPageableDtos(userPageableDtos);

        return usersPageDto;
    }
}
