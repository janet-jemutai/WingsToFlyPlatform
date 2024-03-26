package com.Jemutai.WingsToFly.Platform.scholar;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scholar")
public class StudentController {

    private  final ScholarService scholarService;

    @PostMapping("/addScholar")
    public  ResponseEntity<?>addScholar(@RequestBody Scholar scholar){
     var response =scholarService.addScholar(scholar);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/")
    public  ResponseEntity<?>findAll(){
     var response = scholarService.findAll();
     return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{id}")

    public  ResponseEntity<?>findById(@PathVariable Integer id){
       var response = scholarService.findById(id);
       return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/{id}")

    public  ResponseEntity<?>deleteScholar(@PathVariable Integer id){
      var  response =  scholarService.deleteScholar(id);
        return  ResponseEntity.status(response.getStatusCode()).body(response);

    }
}
