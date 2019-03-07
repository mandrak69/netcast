package com.example.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Clan;
import com.example.dto.ClanDTO;
import com.example.dto.KupljeniPaketiDTO;
import com.example.service.intf.ClanIF;
import com.example.service.intf.GrupaIF;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiError;
import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiHeaders;
import org.jsondoc.core.pojo.ApiVerb;
import org.jsondoc.core.annotation.ApiHeader;

@RestController
@Api(name = "Member services", description = "Methods for managing Member")

@RequestMapping(path="/clan")
public class ClanController {

	@Autowired
	private ClanIF clanService;
	@Autowired
	private GrupaIF grupaService;
	public ClanController() {
		super();
	}

	@ApiMethod
	@GetMapping
	public @ApiResponseObject @ResponseBody Collection<Clan> getAllClan() {
		
		List<Clan> spisakClanova = clanService.findAll();

		return spisakClanova;
	}

	@ApiMethod
	@GetMapping("/members")
	public @ApiResponseObject @ResponseBody  Page<Clan> findAll(Pageable pageable) {
		return clanService.findAll(pageable);
	}
	
	@ApiMethod
	@RequestMapping(path = "/add", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
		public @ResponseBody @ApiResponseObject ClanDTO addNewClan(@RequestBody @ApiBodyObject ClanDTO clandto) {

		ClanDTO clanAdd = clanService.save(clandto);

		return clanAdd;
	}

	
	@GetMapping("/get/{id}")
	@ApiMethod(description = "Get member  by ID ")
	public @ApiResponseObject @ResponseBody Clan getClanbyId(
			@ApiPathParam(description = "The id of the member") @PathVariable(value = "id") long id) {
				
		return clanService.findById(id);
	}
	

	@ApiMethod(

			path="/delete/{id}", 
			verb=ApiVerb.DELETE, 
			description="Deletesmember with the given id",
			produces={MediaType.APPLICATION_JSON_VALUE}

		)
	
		@ApiHeaders(headers={
			@ApiHeader(name="member_id", description="ID of member for delete")
		})
		@ApiErrors(apierrors={
			@ApiError(code="1000", description="Member not found"),
			@ApiError(code="7000", description="Invalid member id"),
			@ApiError(code="9000", description="Illegal argument")
		})
		@ResponseStatus(value=HttpStatus.NO_CONTENT)
		@RequestMapping(headers = "member_id", value = "/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })

		public @ResponseBody void delete(@ApiPathParam(name = "id", description = "Id number") Long id) {
		clanService.delete(id);
	}
	
	
	@ApiMethod
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE },consumes= {MediaType.APPLICATION_JSON_VALUE})

	public ClanDTO updateClan(@PathVariable Long id, @RequestBody ClanDTO clandto) {

		ClanDTO clan_temp = clanService.update(id, clandto);

		return clan_temp;
	}

	@GetMapping(value = "/membersticket/{id}")
	public List<KupljeniPaketiDTO> listaPaketaClana(@PathVariable Long id) {
		return clanService.paketiClana(id);
	}
	

	@GetMapping("/group/{id}")
	public Iterable<Clan> clanoviGrupe(@PathVariable Long id) {

		Iterable<Clan> grupa_temp = clanService.findByGrupa(grupaService.findById(id));

		return grupa_temp;
	}

}
