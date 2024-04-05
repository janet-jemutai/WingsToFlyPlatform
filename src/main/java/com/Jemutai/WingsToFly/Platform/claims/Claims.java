package com.Jemutai.WingsToFly.Platform.claims;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "claims")
public class Claims {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "s_name")
    private  String sname;
    @Column(name = "claim_desc")
     private   String claimdesc;
     @Column(name = "branch")
     private   String branch;






}
