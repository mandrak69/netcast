package com.example.controller;

import java.util.Collection;
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

import com.example.domain.ClanPaket;

import com.example.dto.ClanDTO;
import com.example.dto.ClanPaketDTO;
import com.example.dto.PaketDTO;
import com.example.service.ClanPaketService;
import com.example.service.utility;




@RestController    
@RequestMapping(path="/clanpaket") 
public class ClanPaketController {
	
	
    @Autowired
    private ClanPaketService clanPaketService; 
    
    public ClanPaketController() {
		super();
		
	}
    
    @GetMapping(path="/all")
    public @ResponseBody Collection<ClanPaket> getAllClanPaket() {
		Collection<ClanPaket> clanoviIpaketi = clanPaketService.findAllClanPaket();
	 	 // vraca JSON format clanove 
	   return clanoviIpaketi;
    }
    
	@PostMapping(path="/add")
	public @ResponseBody String addNewClanPaket (@RequestBody ClanDTO clanDto, @RequestBody PaketDTO paketDto)
	{
		   
		clanPaketService.save(clanDto,paketDto);
    	
		return "Saved";
	}
	
	@PostMapping(path="/kupi")
	public @ResponseBody String clanKupujePaket (@RequestBody ClanPaketDTO clanPaketDto)
	{
	   
		
		clanPaketService.save(clanPaketDto);
    	
		return "Kupljen";
	}

	// aktivacija prebacuje kupon u Knjigu. Ideja ,mozda se ne uklopi u poslovni model
	@GetMapping(path="/aktiviraj/{id}")
	public  void aktivirajPaket(@PathVariable Long id) {
		clanPaketService.aktiviraj(id);
		return ;
	}
	
	
	
	@GetMapping(path="/getId/{id}")
	public @ResponseBody ClanPaket getClanPaketbyId(@PathVariable Long id)  {				
    return clanPaketService.findById(id);
    
	}
	
	@PostMapping(path="/getClanPaket")
	public @ResponseBody ClanPaketDTO getClanPaket(@RequestBody ClanPaketDTO clanPaketDto) {
    //  JSON clanovi
		ClanPaket cln = clanPaketService.findById(clanPaketDto.getId());
		utility.prekopiraj(cln,clanPaketDto);
    return clanPaketDto;
}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@RequestBody ClanPaketDTO clanPaketDto) {
		 ClanPaket cln = clanPaketService.findById(clanPaketDto.getId());
		
		 clanPaketService.deleteById(cln.getId());		
	}
	
	
	@PutMapping("/update")
	public ClanPaketDTO updateClanPaket(@RequestBody ClanPaketDTO clanPaketDto) {

		ClanPaketDTO clp_temp = clanPaketService.update(clanPaketDto);

		return clp_temp;
	}
	
	
	
	
}
