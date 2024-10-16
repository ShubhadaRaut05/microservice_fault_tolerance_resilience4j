package com.shubh.citizenservice.Service;

import com.shubh.citizenservice.Entity.Citizen;
import com.shubh.citizenservice.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    public List<Citizen> getById(Integer id)
    {
        return citizenRepository.findByVaccinationCenterId(id);

    }

    public Citizen saveCitizen(Citizen citizen) {
      return  citizenRepository.save(citizen);
    }
}
