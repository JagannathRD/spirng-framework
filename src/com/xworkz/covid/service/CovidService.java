package com.xworkz.covid.service;

import com.xworkz.covid.dto.PatientDTO;

public interface CovidService {

	boolean validateAndSave(PatientDTO dto);
}
