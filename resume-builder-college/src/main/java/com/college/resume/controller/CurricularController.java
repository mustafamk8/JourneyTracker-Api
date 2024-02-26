package com.college.resume.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.college.resume.payloads.ApiResponse;
import com.college.resume.payloads.CurricularDto;
import com.college.resume.service.CurricularService;

@RestController
@RequestMapping("/resume/curricular")
public class CurricularController {

	@Autowired
	private CurricularService curricularService;

	@PostMapping("/scholar/{scholarId}")
	public ResponseEntity<CurricularDto> createCurricular(@RequestBody CurricularDto curricularDto,
			@PathVariable("scholarId") String scholarId) {

		CurricularDto curri = this.curricularService.createCurricular(curricularDto, scholarId);

		return new ResponseEntity<CurricularDto>(curri, HttpStatus.CREATED);
	}

	@PutMapping("/curri/{curriId}")
	public ResponseEntity<CurricularDto> updateCurricular(@RequestBody CurricularDto curricularDto,
			@PathVariable("curriId") Integer curriId) {
		CurricularDto curri = this.curricularService.updateCurricular(curricularDto, curriId);
		return new ResponseEntity<CurricularDto>(curri, HttpStatus.OK);
	}

	@DeleteMapping("/curri/{curriId}")
	public ApiResponse deleteAchievement(@PathVariable("curriId") Integer curriId) {
		this.curricularService.deleteCurricular(curriId);
		return new ApiResponse("Curricular deleted successfully", true);
	}

	@GetMapping("/")
	public ResponseEntity<List<CurricularDto>> getAllCurricular() {
		List<CurricularDto> allCurri = this.curricularService.getAllCurricular();
		return new ResponseEntity<List<CurricularDto>>(allCurri, HttpStatus.OK);
	}

	@GetMapping("/scholarId/{scholarId}")
	public ResponseEntity<List<CurricularDto>> getAllCurriByScholar(@PathVariable("scholarId") String scholarId) {
		List<CurricularDto> allCurriByScholar = this.curricularService.getCurricularByScholar(scholarId);
		return new ResponseEntity<List<CurricularDto>>(allCurriByScholar, HttpStatus.OK);
	}

}
