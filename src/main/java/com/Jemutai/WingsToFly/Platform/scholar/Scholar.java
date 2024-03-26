package com.Jemutai.WingsToFly.Platform.scholar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_scholar")
public class Scholar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admission")
    private  Integer  admission;

    @Column(name = "branch",length = 30)
    private  String branch;

    @Column(name = "scholarCode",length = 20,unique = true)
    private  Integer scholarCode;

    @Column(name = "name",length = 40)
    private String name;


    @Column(name = "form")
    @Enumerated(EnumType.STRING)
     private  Form form;
}
