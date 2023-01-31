package com.example.sahaf.convert;

import com.example.sahaf.dto.UserDto;
import com.example.sahaf.dto.UserPageableDto;
import com.example.sahaf.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserPageableDto userConvertToUserPageableDto(User user) {
        UserPageableDto dto = new UserPageableDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setPhoneNumber(user.getPhoneNumber());

        return dto;
    }

    public UserDto userConvertToUserDto(User user){
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setPhoneNumber(user.getPhoneNumber());

        return dto;
    }

    public User userDtoConvertToUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPhoneNumber(userDto.getPhoneNumber());

        return user;
    }
}
