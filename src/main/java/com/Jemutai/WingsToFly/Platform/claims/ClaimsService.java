package com.Jemutai.WingsToFly.Platform.claims;

import com.Jemutai.WingsToFly.Platform.customResponse.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ClaimsService {


    private  final ClaimsRepo claimsRepo;

    CustomResponse<?> addClaim( Claims claims){
        CustomResponse<Claims> response = new CustomResponse<>();

        try {


                var claim = claimsRepo.save(claims);

                response.setMessage("Claim Added Succesfully");
                response.setPayload(claim);
                response.setSuccess(true);
           response.setStatusCode(HttpStatus.CREATED.value());

        }

        catch (Exception e){
            response.setSuccess(false);
           response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Claim not added successfully" + e.getMessage());
            response.setPayload(null);

        }
        return  response;
    }
}
