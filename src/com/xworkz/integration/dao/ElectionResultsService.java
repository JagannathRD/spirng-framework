package com.xworkz.integration.dao;

import java.util.List;

import com.xworkz.integration.dto.ElectionResultsDto;

public interface ElectionResultsService {
	
	public String validateAndSave(ElectionResultsDto dto);

	public void updateWardNoById(int wardNo, long id );

	public ElectionResultsDto getByPartyName(String name);

	public List<ElectionResultsDto> getList();
}
