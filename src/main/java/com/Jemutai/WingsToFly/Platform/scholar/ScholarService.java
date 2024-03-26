package com.Jemutai.WingsToFly.Platform.scholar;

import com.Jemutai.WingsToFly.Platform.customResponse.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScholarService {

    private  final  ScholarRepo scholarRepo;


    //add a new scholar
    CustomResponse<?>addScholar(Scholar scholar){
        CustomResponse<Scholar> response = new CustomResponse<>();

        try {
            //get scholar code to check if it exists

            Integer scholarCode = scholar.getScholarCode();

            Optional<Scholar>optionalScholar = scholarRepo.findScholarByScholarCode(scholarCode);

            if (optionalScholar.isPresent()) {
                response.setMessage("Scholar Already exist");
                response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            }

                else{
                    var sch = scholarRepo.save(scholar);

                    response.setSuccess(true);
                    response.setMessage("Scholar added succesfully");
                    response.setPayload(sch);
                    response.setStatusCode(HttpStatus.CREATED.value());
                }
        }

        catch (Exception e){
            e.printStackTrace();
            response.setMessage("An error occured while adding the scholar");
            response.setSuccess(false);
            response.setStatusCode(null);
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return  response;
    }

    CustomResponse<?>findAll(){
        CustomResponse<List<Scholar>> response= new CustomResponse<>();

        try {


       var scholars = scholarRepo.findAll();

        response.setMessage("Scholars List");
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setSuccess(true);
        response.setPayload(scholars);
        }
        catch (Exception e){
            response.setMessage("Error occurred while finding list of students");
            response.setPayload(null);
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return  response;

    }

    CustomResponse<?>findById(Integer id){
        CustomResponse <Optional<Scholar>>response = new CustomResponse<>();

        try {
            Optional<Scholar>optionalScholar =scholarRepo.findById(id);

            if (optionalScholar.isPresent()){
                response.setMessage("Scholar found");
                response.setSuccess(true);
                response.setStatusCode(HttpStatus.FOUND.value());
             response.setPayload(optionalScholar);
            }
            else {
                response.setMessage("Student not found");
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
            }

        }
        catch (Exception e){
            response.setMessage("An Error occurred "+ e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return response;
    }

    CustomResponse<?>deleteScholar(Integer id){
        CustomResponse<Scholar>response = new CustomResponse<>();
        try{
            Optional<Scholar>optionalScholar =scholarRepo.findById(id);

            if (optionalScholar.isPresent()){
                Scholar scholar =optionalScholar.get();
                scholarRepo.delete(scholar);

                response.setMessage("Scholar deleted successfully");
                response.setStatusCode(HttpStatus.OK.value());
                response.setSuccess(true);
            }
            else {
                response.setMessage("Scholar not found");
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
            }
        }
        catch (Exception e){
            response.setMessage("Error occured" +e.getMessage());
            response.setSuccess(false);
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return  response;
    }
}
