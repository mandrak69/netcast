package com.example.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ClanPaketDAO;
import com.example.domain.ClanPaket;
import com.example.domain.DTO.ClanDTO;
import com.example.domain.DTO.ClanPaketDTO;
import com.example.domain.DTO.PaketDTO;
import com.example.service.ClanPaketService;




@RestController    
@RequestMapping(path="/clanpaket") 
public class ClanPaketController {
	
	@Autowired      
	private ClanPaketDAO clanPaketDao;
    @Autowired
    private ClanPaketService clanPaketService; 
    @Autowired
	

    
    public ClanPaketController() {
		super();
		
	}
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<ClanPaket> getAllClanPaket() {
		
		return clanPaketDao.findAll();
	}
    
	@PostMapping(path="/add")
	public @ResponseBody String addNewClanPaket (@RequestBody ClanDTO clanDto, @RequestBody PaketDTO paketDto)
	{
		   
		clanPaketService.save(clanDto,paketDto);
    	
		return "Saved";
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createClanPaket(@RequestBody ClanDTO clanDto, @RequestBody PaketDTO paketDto) {
			
		return  ResponseEntity.ok().body(clanPaketService.create(clanDto,paketDto));
	}
	
	@GetMapping(path="/getId/{id}")
	public @ResponseBody ClanPaket getClanPaketbyId(@PathVariable Long id)  {				
    return clanPaketService.findById(id);
    
	}
	
	@GetMapping(path="/getPaket")
	public @ResponseBody Optional<ClanPaket> getClanPaketbyDTO(@RequestBody ClanPaketDTO clanPaketDto) {
    //  JSON clanovi
    return clanPaketDao.findById(clanPaketDto.getId());
}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteClanPaket(@PathVariable("id") Long id) {
		clanPaketDao.deleteById(id);		
	}
	@PutMapping("/update")
	public ResponseEntity<Object> updateClanPaket(@RequestBody ClanPaket clanPaket) {

		ResponseEntity<Object> t = clanPaketService.update(clanPaket);

		return t;
	}
	
	
	
	
}
