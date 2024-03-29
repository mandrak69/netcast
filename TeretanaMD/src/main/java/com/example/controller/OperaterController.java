package com.example.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
//import javax.validation.Valid;

//import org.jsondoc.core.annotation.Api;
//import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Operater;
import com.example.dto.OperaterDTO;
import com.example.security.LoginService;
import com.example.service.intf.OperaterIF;

//import org.jsondoc.core.annotation.Api;

import org.jsondoc.core.annotation.ApiMethod;



@RestController
@RequestMapping(value = "/operater")
public class OperaterController {
	
	@Autowired	
	private LoginService loginService;
	
	@Autowired
	private OperaterIF operaterService;
		
	public OperaterController() {
		super();
		
	}


    @PostMapping(path="/add") 
	public @ResponseBody OperaterDTO addNewOperater (@RequestBody OperaterDTO operaterdto) {
		
	OperaterDTO radAdd = operaterService.save(operaterdto);
		
	return radAdd;
	}
	
    @ApiMethod(description="login")
	@PostMapping(value = "/login")
	public String login(@RequestBody OperaterDTO operaterDTO) throws ServletException {
		return loginService.authorize(operaterDTO);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {	
		operaterService.delete(id);		
	}
	
	@GetMapping(path="/all")
	   public @ResponseBody Collection<Operater> getAllOperater() {
		  List<Operater> spisoperatera = operaterService.findAll();
	 	 
	   return spisoperatera;
	}
	

	
	@GetMapping(path="/get/{id}")
	public @ResponseBody Operater getOperaterbyId(@PathVariable Long id)  {				
 return operaterService.findById(id);
 
	}

	@PutMapping("/update/{id}")
	public OperaterDTO updateOperater(@PathVariable Long id,@RequestBody OperaterDTO clandto) {

		OperaterDTO clan_temp = operaterService.update(id,clandto);

		return clan_temp;
	}
	
	
}