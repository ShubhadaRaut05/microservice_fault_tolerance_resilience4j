package com.shubh.citizenservice.Controller;

import com.shubh.citizenservice.Entity.Citizen;
import com.shubh.citizenservice.Service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Citizen>> getById (@PathVariable Integer id)
    {
        List<Citizen> listCitizen=citizenService.getById(id);
        return new ResponseEntity<>(listCitizen, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen )
    {
        Citizen savedCitizen=citizenService.saveCitizen(citizen);
        return new ResponseEntity<>(savedCitizen,HttpStatus.OK);
    }
}
