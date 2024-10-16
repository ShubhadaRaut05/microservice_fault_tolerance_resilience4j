package com.shubh.vaccinationcenterservice.dto;

import com.shubh.vaccinationcenterservice.entity.VaccinationCenter;
import com.shubh.vaccinationcenterservice.model.Citizen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitizenResponseDTO {
    private VaccinationCenter vaccinationCenter;
    private List<Citizen> citizens;

}
