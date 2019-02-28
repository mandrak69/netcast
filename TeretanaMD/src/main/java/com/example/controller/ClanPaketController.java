package com.example.controller;

import java.util.Collection;
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

import com.example.dao.ClanDAO;
import com.example.dao.ClanPaketDAO;
import com.example.dao.PaketDAO;
import com.example.domain.Clan;
import com.example.domain.ClanPaket;
import com.example.domain.Paket;
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
    
    @Autowired      
	private ClanDAO clanDao;
    @Autowired      
	private PaketDAO paketDao;
    
    public ClanPaketController() {
		super();
		
	}
    
    @GetMapping(path="/all")
    public @ResponseBody Collection<ClanPaket> getAllClanPaket() {
		Collection<ClanPaket> kk = clanPaketService.findAllClanPaket();
	 	 // vraca JSON format clanove 
	   return kk;
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

	
	@GetMapping(path="/aktiviraj/{id}")
	public  void aktivirajPaket(@PathVariable Long id) {
		clanPaketService.aktiviraj(id);
		return ;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Object> createClanPaket(@RequestBody ClanDTO clanDto, @RequestBody PaketDTO paketDto) {
			
		return  ResponseEntity.ok().body(clanPaketService.create(clanDto,paketDto));
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
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@RequestBody ClanPaketDTO clanPaketDto) {
		 ClanPaket cln = clanPaketService.findById(clanPaketDto.getId());
		
		 clanPaketService.deleteById(cln.getId());		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateClanPaket(@RequestBody ClanPaketDTO clanPaketDto) {

		ResponseEntity<Object> t = clanPaketService.update(clanPaketDto);

		return t;
	}
	
	
	// prebaciti u servis ako ispadne korisno
	
	@GetMapping("/createID/{idclan}/{idpaket}")
	public ResponseEntity<Object> createClanPaket(@PathVariable Long idclan,@PathVariable Long idpaket) {
			Optional<Clan> clance = clanPaketService.;
			Optional<Paket> paketce = paketDao.findById(idpaket);
		ClanPaket cpd=new ClanPaket();
		cpd.setClan(clance.get());
		cpd.setPaket(paketce.get());
		return  ResponseEntity.ok().body(clanPaketDao.save(cpd));
	}
	
	
}
