package com.xworkz.integration;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.integration.dao.ElectionResultsService;
import com.xworkz.integration.dto.ElectionResultsDto;

public class InterfaceTester {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext container= new ClassPathXmlApplicationContext("resources/context.xml"); ){
			System.out.println(Arrays.toString(container.getBeanDefinitionNames()));
			
			ElectionResultsDto dto= new ElectionResultsDto();
			dto.setResultId(4);
			dto.setCandidateName("BSP");
			dto.setPartyName("BJP");
			dto.setWardNo(323);
			dto.setWonBy(22500);
			
			ElectionResultsService impl=container.getBean(ElectionResultsService.class);
			//impl.validateAndSave(dto);
			
			//impl.updateWardNoById(108, 1);
			System.out.println();
			dto=impl.getByPartyName("BJP");
			System.out.println("Party by name "+ dto);
			
			List<ElectionResultsDto> dtos=impl.getList();
			Iterator<ElectionResultsDto> iterator =dtos.iterator();
			System.out.println("List");
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
				
			}
			
			
			
			
		}
	}
}
