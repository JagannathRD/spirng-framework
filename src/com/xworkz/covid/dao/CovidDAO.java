package com.xworkz.covid.dao;

import com.xworkz.covid.dto.PatientDTO;

public interface CovidDAO {

	long save(PatientDTO dto);
}
