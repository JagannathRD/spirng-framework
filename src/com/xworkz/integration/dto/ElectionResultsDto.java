package com.xworkz.integration.dto;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "election_results_dto")
public class ElectionResultsDto implements Serializable {
	@Id
	@Column(name="result_id")
	private long resultId;
	@Column(name="party_name")
	private String partyName;
	@Column(name="candidate_name")
	private String candidateName;
	@Column(name="ward_no")
	private int wardNo;
	@Column(name="wonby")
	private int wonBy;

	public ElectionResultsDto() {
		System.out.println("created " + this.getClass().getSimpleName());

	}

	public long getResultId() {
		return resultId;
	}

	public void setResultId(long resultId) {
		this.resultId = resultId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public int getWardNo() {
		return wardNo;
	}

	public void setWardNo(int wardNo) {
		this.wardNo = wardNo;
	}

	public int getWonBy() {
		return wonBy;
	}

	public void setWonBy(int wonBy) {
		this.wonBy = wonBy;
	}

	@Override
	public String toString() {
		return "ElectionResultsDto [resultId=" + resultId + ", partyName=" + partyName + ", candidateName="
				+ candidateName + ", wardNo=" + wardNo + ", wonBy=" + wonBy + "]";
	}
}
