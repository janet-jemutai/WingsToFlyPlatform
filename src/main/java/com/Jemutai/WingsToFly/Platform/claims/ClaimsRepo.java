package com.Jemutai.WingsToFly.Platform.claims;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaimsRepo extends JpaRepository<Claims,String> {
    Optional<Claims> findBySname(String sname);
}
