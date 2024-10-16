package com.shubh.citizenservice.Repository;

import com.shubh.citizenservice.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {
    public List<Citizen> findByVaccinationCenterId(Integer vaccinationCenterId);
}
