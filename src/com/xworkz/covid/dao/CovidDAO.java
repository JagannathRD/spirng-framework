package com.xworkz.covid.dao;

import com.xworkz.covid.dto.PatientDTO;
import com.xworkz.covid.exception.RepositoryException;

public interface CovidDAO {

	long save(PatientDTO dto) throws RepositoryException;
}
