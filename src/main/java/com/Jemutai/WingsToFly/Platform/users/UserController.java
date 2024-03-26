package com.Jemutai.WingsToFly.Platform.users;

import com.Jemutai.WingsToFly.Platform.customResponse.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private  final  UserService userService;
     @PostMapping
   public ResponseEntity<CustomResponse<?>> addUser(@RequestBody Users user){
        CustomResponse<?> response = userService.addUser(user);
       return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}

