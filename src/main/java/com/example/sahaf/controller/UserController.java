package com.example.sahaf.controller;

import com.example.sahaf.dto.UserDto;
import com.example.sahaf.dto.UsersPageDto;
import com.example.sahaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @GetMapping("all")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<UserDto> findById(@PathVariable int id) {
        UserDto userDto = userService.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("{no}/{size}")
    public UsersPageDto getUsers(@PathVariable int no, @PathVariable int size){
        return userService.getUsersList(no, size);
    }
}
