package com.Jemutai.WingsToFly.Platform.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Integer id;

    @Column(name = "user_name",length = 50)
    private  String name;

    @Column(name = "pf_number",length = 10)
    private  String  pf;


    @Column(name = "phone_number",length = 14,unique = true)
    private  int phoneNumber;

    @Column(name = "branch",length = 20)
    private  String branch;

    @Column(name = "email",unique = true,length = 50)
    private  String email;


    @Column(name = "password")
    private  String password;


    @Column(name = "role")

    @Enumerated(EnumType.STRING)
    private  Role role;
}
