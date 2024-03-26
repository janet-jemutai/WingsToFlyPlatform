package com.Jemutai.WingsToFly.Platform.users;

import com.Jemutai.WingsToFly.Platform.customResponse.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final  UserRepo userRepo;

    public CustomResponse<?>addUser(Users users){
        CustomResponse<?>
    }
}
