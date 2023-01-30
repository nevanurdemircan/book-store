package com.example.sahaf.controller;

import com.example.sahaf.dto.UsersPageDto;
import com.example.sahaf.entities.User;
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

    @PostMapping("save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User resultUser = userService.saveUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int id) {
        Boolean status = userService.delete(id);
        return ResponseEntity.ok(status);
    }

    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User resultUser = userService.updateUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable int id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{no}/{size}")
    public UsersPageDto getUsers(@PathVariable int no, @PathVariable int size){
        return userService.getUsersList(no, size);
    }
}
