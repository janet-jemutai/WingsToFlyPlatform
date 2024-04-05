package com.Jemutai.WingsToFly.Platform.claims;

import com.Jemutai.WingsToFly.Platform.customResponse.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    CustomResponse<?> getClaims(){
        CustomResponse<List<Claims>> response = new CustomResponse<>();

        try {

            var claims = claimsRepo.findAll();

            response.setMessage("Claims List");
            response.setSuccess(true);
            response.setPayload(claims);
            response.setStatusCode(HttpStatus.OK.value());

        }

        catch (Exception e){
            response.setMessage("List of Claims not available"  + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setPayload(null);
            response.setSuccess(false);
        }

        return  response;
    }


     CustomResponse<?> findBySname(String sname){
        CustomResponse<Optional<Claims>> response = new CustomResponse<>();

        try {
            Optional<Claims> optionalClaims = claimsRepo.findBySname(sname);

            if (optionalClaims.isPresent()){
                response.setSuccess(true);
                response.setMessage("Claim found");
                response.setStatusCode(HttpStatus.FOUND.value());
                response.setPayload(optionalClaims);
            }
            else {
                response.setPayload(null);
                response.setMessage("Claim not found");
            }

        }

        catch ( Exception e){
            response.setSuccess(false);
            response.setMessage("Failed to get Claim");
            response.setPayload(null);
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return  response;
     }
}
