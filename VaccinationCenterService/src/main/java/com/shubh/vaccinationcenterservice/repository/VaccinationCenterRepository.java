package com.shubh.vaccinationcenterservice.repository;

import com.shubh.vaccinationcenterservice.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Long> {
}
