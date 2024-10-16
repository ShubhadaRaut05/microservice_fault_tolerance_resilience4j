package com.shubh.vaccinationcenterservice.controller;


import com.shubh.vaccinationcenterservice.dto.CitizenResponseDTO;
import com.shubh.vaccinationcenterservice.entity.VaccinationCenter;
import com.shubh.vaccinationcenterservice.model.Citizen;
import com.shubh.vaccinationcenterservice.service.VaccinationCenterService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccination")
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterService vaccinationCenterService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter )
    {
        VaccinationCenter savedVaccinationCenter=vaccinationCenterService.saveVaccinationCenter(vaccinationCenter);
        return new ResponseEntity<>(savedVaccinationCenter, HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    @CircuitBreaker(name="circuit_active",fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<CitizenResponseDTO> getAllDataBasedonCneterId(@PathVariable Long id)
    {
        CitizenResponseDTO response=new CitizenResponseDTO();
        //1st get vaccination center details
        VaccinationCenter vaccinationCenter=vaccinationCenterService.getByCenterId(id).get();
        response.setVaccinationCenter(vaccinationCenter);

        //get all citizens registers to vaccination center
        //you need to connect to the CitizenService
        //To connect one microservice to another microservice we need RestTemplate.
//      List<Citizen> listOfCitizens= restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
        //It gives endpoint from Eureka not from localhost
        List<Citizen> listOfCitizens= restTemplate.getForObject("http://CitizenService/citizen/id/"+id, List.class);
        response.setCitizens(listOfCitizens);
        return new ResponseEntity<CitizenResponseDTO>(response,HttpStatus.OK);
    }

    public ResponseEntity<CitizenResponseDTO> handleCitizenDownTime(Long id,Exception e)
    {
        CitizenResponseDTO response=new CitizenResponseDTO();
        VaccinationCenter vaccinationCenter=vaccinationCenterService.getByCenterId(id).get();
        response.setVaccinationCenter(vaccinationCenter);
        return new ResponseEntity<CitizenResponseDTO>(response,HttpStatus.OK);
    }

}
