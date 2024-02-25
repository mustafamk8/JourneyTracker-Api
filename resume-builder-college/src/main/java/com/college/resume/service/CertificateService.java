package com.college.resume.service;

import java.util.List;

import com.college.resume.payloads.CertificateDto;

public interface CertificateService {
	
	CertificateDto createCertificate(CertificateDto certificateDto, String scholar);
	
	CertificateDto updateCertificate(CertificateDto certificateDto, Integer id);
	
	void deleteCertificate(Integer id);
	
	List<CertificateDto> getCertificateByScholar(String scholar);
	
	List<CertificateDto> getAllCertificate();

}
