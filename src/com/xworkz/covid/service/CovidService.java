package com.xworkz.covid.service;

import com.xworkz.covid.dto.PatientDTO;
import com.xworkz.covid.exception.ServiceException;

public interface CovidService {

	boolean validateAndSave(PatientDTO dto) throws ServiceException;
}
