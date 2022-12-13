package com.arabsoft.ajir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arabsoft.ajir.dao.CompetenceDetRep;
import com.arabsoft.ajir.dao.CompetenceRep;
import com.arabsoft.ajir.dao.CompetencesReqRep;
import com.arabsoft.ajir.dao.NatCompetanceRep;
import com.arabsoft.ajir.dao.PersonnelRep;
import com.arabsoft.ajir.entities.CessionPers;
import com.arabsoft.ajir.entities.Competence;
import com.arabsoft.ajir.entities.CompetenceDet;
import com.arabsoft.ajir.entities.CompetencesReq;
import com.arabsoft.ajir.entities.NatCompetance;
import com.arabsoft.ajir.entities.Personnel;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class CompetencesController {
	
	@Autowired
	CompetenceDetRep competenceDetRep;
	
	@Autowired
	CompetencesReqRep competencesReqRep;
	
	
	@Autowired
	NatCompetanceRep natCompetenceRep;
	
	@Autowired
	PersonnelRep personnelRep;
	
	
	
	@CrossOrigin
	@GetMapping("/getcomptence/{matPers}")
	 public List<CompetenceDet> getListCodPretPers(@PathVariable String matPers){
		
		
		
		return competenceDetRep.getCompetenceServ(matPers);
		
		
	}
	
	@CrossOrigin
	@GetMapping("/getcomptencereq/{matPers}/{matPersAgent}")
	 public List<CompetenceDet> getListCompetencesReq(@PathVariable String matPers,@PathVariable String matPersAgent){

		return competenceDetRep.getCompetenceRequise(matPers,matPersAgent);

	}
	
	@CrossOrigin
	@GetMapping("/getlispesonel/{codSoc}/{matPers}")
	 public List<Personnel> getListPersonnel(@PathVariable String codSoc,@PathVariable String matPers){

		return personnelRep.getPersService(codSoc, matPers);

	}
	@CrossOrigin
	@GetMapping("/getcomptencereq/{matPers}")
	 public List<CompetencesReq> getListCompetencesReq(@PathVariable String matPers){

		return competencesReqRep.getCompetenceRequise(matPers);

	}
	
	
	@CrossOrigin
	@GetMapping("/getcomptencereqpers/{matPers}/{matPersAgent}")
	 public List<CompetencesReq> getListCompetencesReqPers(@PathVariable String matPers,@PathVariable String matPersAgent){

		return competencesReqRep.getCompetenceRequisePers(matPers,matPersAgent);

	}
	
	
	@GetMapping("/getallcompetence")
	public List<NatCompetance>  getall(){
			return  natCompetenceRep.findAll();
		}
	
	
	
}
