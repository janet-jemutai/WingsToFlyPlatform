package com.Jemutai.WingsToFly.Platform.scholar;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScholarRepo extends JpaRepository<Scholar,Integer> {
    Optional<Scholar> findScholarByScholarCode(Integer scholarCode);

    //Scholar deleteById(Scholar scholar);
}
