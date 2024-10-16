package com.shubh.vaccinationcenterservice.service;

import com.shubh.vaccinationcenterservice.entity.VaccinationCenter;
import com.shubh.vaccinationcenterservice.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccinationCenterService {
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;


    public VaccinationCenter saveVaccinationCenter(VaccinationCenter vaccinationCenter) {
        return vaccinationCenterRepository.save(vaccinationCenter);
    }
    public Optional<VaccinationCenter> getByCenterId(Long centerId){
        return Optional.of(vaccinationCenterRepository.findById(centerId).get());

    }
}
