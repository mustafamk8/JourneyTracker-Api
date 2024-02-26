package com.college.resume.service;

import java.util.List;

import com.college.resume.payloads.CurricularDto;

public interface CurricularService {

	CurricularDto createCurricular(CurricularDto curricularDto, String scholarNo);
	CurricularDto updateCurricular(CurricularDto curricularDto, Integer id);
	List<CurricularDto> getCurricularByScholar(String scholar);
	List<CurricularDto> getAllCurricular();
	void deleteCurricular(Integer id);
	
}
