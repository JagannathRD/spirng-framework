package com.xworkz.integration.dao;

import java.util.List;

import com.xworkz.integration.dto.ElectionResultsDto;

public class ElectionResultsServiceImpl implements ElectionResultsService {

	private ElectionResultsInterface resultsInterface;

	public ElectionResultsServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " created...");
	}

	@Override
	public String validateAndSave(ElectionResultsDto dto) {
		String candidateName = dto.getCandidateName();
		String partyName = dto.getPartyName();

		int wardNo = dto.getWardNo();
		int wonBy = dto.getWonBy();

		boolean valid = false;
		String message = "failed";
		if (candidateName != null && !candidateName.isEmpty()) {
			System.out.println("Candidate Name is  valid");
			valid = true;
		} else {

			System.out.println("Candidate Name is not valid");
			valid = false;
		}

		if (valid) {
			if (partyName != null && partyName.length() >= 3 && partyName.length() <= 15) {
				System.out.println("party Name is  valid");
				valid = true;
			} else {

				System.out.println("party Name is not valid");
				valid = false;
			}
		}

		if (valid) {
			if (wardNo >= 1 && wardNo <= 500) {
				System.out.println("wardNo is  valid");
				valid = true;
			} else {

				System.out.println("wardNo is not valid");
				valid = false;
			}
		}

		if (valid) {
			if (wonBy > 0) {
				System.out.println(" wonBy is  valid");
				valid = true;
			} else {

				System.out.println(" wonBy is not valid");
				valid = false;
			}
		}

		if (valid) {
			resultsInterface.save(dto);
			message = "saved";
			System.out.println("Saved");
		} else {
			message = "failed";
			System.out.println("failed");
		}
		return message;
	}

	@Override
	public void updateWardNoById(int wardNo, long id ) {
		resultsInterface.updateWardNoById(wardNo, id);
		System.out.println("updated....");
	}

	@Override
	public ElectionResultsDto getByPartyName(String name) {

		return null;
	}

	@Override
	public List<ElectionResultsDto> getList() {

		return null;
	}

	public ElectionResultsInterface getResultsInterface() {
		return resultsInterface;
	}

	public void setResultsInterface(ElectionResultsInterface resultsInterface) {
		this.resultsInterface = resultsInterface;
	}

}
