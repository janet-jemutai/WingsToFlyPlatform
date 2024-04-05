package com.Jemutai.WingsToFly.Platform.claims;

import com.Jemutai.WingsToFly.Platform.scholar.Scholar;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/claims")
public class ClaimsController {

    private  final ClaimsService claimsService;

    @PostMapping("/addClaim")

    public  ResponseEntity<?> addClaim(@RequestBody Claims claims){
        var  response = claimsService.addClaim(claims);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }


    @GetMapping("/")

    public  ResponseEntity <?> findClaims(){
        var response = claimsService.getClaims();
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{sname}")

    public  ResponseEntity <?> findBySname(@PathVariable String sname){
        var response = claimsService.findBySname(sname);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }




//    @PostMapping("/addScholar")
//    public ResponseEntity<?> addScholar(@RequestBody Scholar scholar){
//        var response =scholarService.addScholar(scholar);
//        return ResponseEntity.status(response.getStatusCode()).body(response);
}
