package com.Jemutai.WingsToFly.Platform.claims;

import com.Jemutai.WingsToFly.Platform.scholar.Scholar;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




//    @PostMapping("/addScholar")
//    public ResponseEntity<?> addScholar(@RequestBody Scholar scholar){
//        var response =scholarService.addScholar(scholar);
//        return ResponseEntity.status(response.getStatusCode()).body(response);
}
