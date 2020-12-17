package com.xworkz.integration;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.integration.dao.ElectionResultsService;
import com.xworkz.integration.dto.ElectionResultsDto;

public class InterfaceTester {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext container= new ClassPathXmlApplicationContext("resources/context.xml"); ){
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			
			ElectionResultsDto dto= new ElectionResultsDto();
			dto.setResultId(2);
			dto.setCandidateName("BSY");
			dto.setPartyName("BSY");
			dto.setWardNo(111);
			dto.setWonBy(22222);
			
			ElectionResultsService impl=container.getBean(ElectionResultsService.class);
			impl.validateAndSave(dto);
			
			impl.updateWardNoById(108, 1);
		}
	}
}
