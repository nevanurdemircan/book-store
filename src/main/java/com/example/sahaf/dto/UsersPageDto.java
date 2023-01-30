package com.example.sahaf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersPageDto {
    private int count;
    private List<UserPageableDto>userPageableDtos;
}
