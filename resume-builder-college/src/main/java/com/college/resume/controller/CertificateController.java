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
import com.college.resume.payloads.CertificateDto;
import com.college.resume.service.CertificateService;

@RestController
@RequestMapping("resume/certificate")
public class CertificateController {
	
	@Autowired
	private CertificateService certificateService;
	
	@PostMapping("/scholar/{scholar}")
	public ResponseEntity<CertificateDto> createCertificate(@RequestBody CertificateDto certificateDto,@PathVariable("scholar") String scholar){
		CertificateDto certi = this.certificateService.createCertificate(certificateDto, scholar);
		return new ResponseEntity<CertificateDto>(certi,HttpStatus.CREATED);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<CertificateDto> updateCertificate(@RequestBody CertificateDto certificateDto, @PathVariable("id") Integer id){
		CertificateDto updatedCerti = this.certificateService.updateCertificate(certificateDto, id);
		return new ResponseEntity<CertificateDto>(updatedCerti,HttpStatus.OK);
	}
	
	@GetMapping("/scholar/{scholarId}")
	public ResponseEntity<List<CertificateDto>> getCertiByScholar(@PathVariable("scholarId") String scholarId){
		List<CertificateDto> list = this.certificateService.getCertificateByScholar(scholarId);
		return new ResponseEntity<List<CertificateDto>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CertificateDto>> getAllCertificate(){
		List<CertificateDto> list = this.certificateService.getAllCertificate();
		return new ResponseEntity<List<CertificateDto>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ApiResponse deleteCertificate(@PathVariable("id") Integer id) {
		this.certificateService.deleteCertificate(id);
		return new ApiResponse("Certificate deleted successfully",true);
	}

}
