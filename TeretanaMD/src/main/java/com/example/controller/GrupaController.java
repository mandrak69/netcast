package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiHeaders;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.domain.Grupa;
import com.example.dto.GrupaDTO;
import com.example.service.intf.GrupaIF;

import org.jsondoc.core.annotation.ApiError;


//import org.jsondoc.core.annotation.ApiParam;



@RestController    
@RequestMapping(path="/grupa") 
public class GrupaController {
	
	
	@Autowired
	private GrupaIF grupaService;
	
	public GrupaController() {
		super();	
	}
	
	@GetMapping(path="/all")
	   public @ResponseBody Collection<Grupa> getAllGrupa() {
		  List<Grupa> spisakgrupa = grupaService.findAll();
	 	 
	   return spisakgrupa;
	}
	
	@GetMapping("/clanovi")
	public Page<Grupa> findAll(Pageable pageable){
		return grupaService.findAll(pageable);
	}
	
	@PostMapping(path="/add") 
	public @ResponseBody GrupaDTO addNewGrupa (@RequestBody GrupaDTO grupadto) {
		
		 GrupaDTO grupaAdd = grupaService.save(grupadto);
		
	return grupaAdd;
	}
	
	
	
	
	
	@ApiMethod(
	        path = "/get/{id}",
	        verb = ApiVerb.GET,
	        description = "Gets all groups ",
	        produces = { MediaType.APPLICATION_JSON_VALUE },
	        consumes = { MediaType.APPLICATION_JSON_VALUE },
	       
	        responsestatuscode = "201 - Created"
	)
	
	@ApiErrors(apierrors={
	        @ApiError(code="2000", description="Group not found"),
	        @ApiError(code="9000", description="Illegal argument")
	})
	public @ApiResponseObject Grupa getGrupabyId(@PathVariable Long id)  {				
    return grupaService.findById(id);
    
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {	
		grupaService.delete(id);		
	}	
	
	
	
	@PutMapping("/update/{id}")
	public GrupaDTO updateGrupa(@PathVariable Long id,@RequestBody GrupaDTO grupadto) {

		GrupaDTO grupa_temp = grupaService.update(id,grupadto);

		return grupa_temp;
	}
	
	
	
	
	
	
}
