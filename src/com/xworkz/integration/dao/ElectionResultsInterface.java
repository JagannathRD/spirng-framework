package com.xworkz.integration.dao;

import java.util.List;

import com.xworkz.integration.dto.ElectionResultsDto;

public interface ElectionResultsInterface {
	
	void save(ElectionResultsDto dto);
	
	void updateWardNoById(int wardNo, long resultId );
	
	ElectionResultsDto getByPartyName(String name);
	
	List<ElectionResultsDto> getList();

	default void delete(){
		
	}
}
