package com.college.resume.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.resume.entity.Curricular;
import com.college.resume.entity.StudentPersonel;
import com.college.resume.exception.ResourceNotFoundException;
import com.college.resume.exception.ResourceNotFoundExceptionAll;
import com.college.resume.payloads.CurricularDto;
import com.college.resume.repository.CurricularRepo;
import com.college.resume.repository.StudentPersonelRepo;
import com.college.resume.service.CurricularService;

@Service
public class CurricularServiceImpl implements CurricularService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private StudentPersonelRepo studentPersonelRepo;

	@Autowired
	private CurricularRepo curricularRepo;

	@Override
	public CurricularDto createCurricular(CurricularDto curricularDto, String scholarNo) {
		// TODO Auto-generated method stub
		StudentPersonel student = this.studentPersonelRepo.findById(scholarNo)
				.orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
		Curricular curi = this.dtoToCurricular(curricularDto);
		curi.setScholarNo(student);
		Curricular savedCurri = this.curricularRepo.save(curi);
		return this.curricularToDto(savedCurri);
	}

	@Override
	public CurricularDto updateCurricular(CurricularDto curricularDto, Integer id) {
		Curricular curri = this.curricularRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionAll("Curricular", "Id", id));
		curri.setCurriName(curricularDto.getCurriName());
		Curricular updatedCurri = this.curricularRepo.save(curri);
		return this.curricularToDto(updatedCurri);
	}

	@Override
	public List<CurricularDto> getCurricularByScholar(String scholar) {
		StudentPersonel student = this.studentPersonelRepo.findById(scholar)
				.orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		List<Curricular> curriList = this.curricularRepo.findByScholarNo(student);
		List<CurricularDto> list = curriList.stream().map(curi -> this.curricularToDto(curi))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<CurricularDto> getAllCurricular() {
		List<Curricular> curi = this.curricularRepo.findAll();
		List<CurricularDto> list = curi.stream().map(a -> this.curricularToDto(a)).collect(Collectors.toList());

		return list;
	}

	@Override
	public void deleteCurricular(Integer id) {
		Curricular curi = this.curricularRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionAll("Curricular", "Id", id));
		this.curricularRepo.delete(curi);

	}

	public Curricular dtoToCurricular(CurricularDto curricularDto) {
		Curricular curi = this.modelMapper.map(curricularDto, Curricular.class);
		return curi;
	}

	public CurricularDto curricularToDto(Curricular curi) {
		CurricularDto curiDto = this.modelMapper.map(curi, CurricularDto.class);
		return curiDto;

	}

}
