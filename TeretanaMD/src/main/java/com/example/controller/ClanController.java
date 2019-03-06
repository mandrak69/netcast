package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;

import org.jsondoc.core.annotation.ApiError;
import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiHeaders;
import org.jsondoc.core.pojo.ApiVerb;
import org.jsondoc.core.annotation.ApiHeader;

@RestController
@Api(name = "Member services", description = "Methods for managing Member", group = "Main", visibility = ApiVisibility.PUBLIC, stage = ApiStage.RC)
@ApiVersion(since = "1.0", until = "2.12")


@RequestMapping(value="/clan")
public class ClanController {

	@Autowired
	private ClanIF clanService;

	public ClanController() {
		super();
	}

	@ApiMethod
	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ApiResponseObject @ResponseBody Collection<Clan> getAllClan() {
		
		List<Clan> spisakClanova = clanService.findAll();

		return spisakClanova;
	}

	@ApiMethod
	@RequestMapping(path = "/clanovi", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
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

	
	@ApiMethod
	@RequestMapping(path = "/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })

	public @ApiResponseObject @ResponseBody Clan getClanbyId(
			@ApiPathParam(description = "The id of the member") @PathVariable(value = "id") Long id) {
		
		return clanService.findById(id);

	}
	
	

	@ApiMethod(

			path="/countries/{id}", 
			verb=ApiVerb.DELETE, 
			description="Deletes the country with the given id",
			produces={MediaType.APPLICATION_JSON_VALUE}

		)
	
		@ApiHeaders(headers={
			@ApiHeader(name="application_id", description="The application id")
		})
		@ApiErrors(apierrors={
			@ApiError(code="1000", description="Country not found"),
			@ApiError(code="7000", description="Invalid application id"),
			@ApiError(code="9000", description="Illegal argument")
		})
		@ResponseStatus(value=HttpStatus.NO_CONTENT)
		@RequestMapping(headers = "application_id", value = "/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })

		public @ResponseBody void delete(@ApiPathParam(name = "id", description = "Id number") Long id) {
		clanService.delete(id);
	}
	
	
	
	
	

	@PutMapping("/update/{id}")
	public ClanDTO updateClan(@PathVariable Long id, @RequestBody ClanDTO clandto) {

		ClanDTO clan_temp = clanService.update(id, clandto);

		return clan_temp;
	}

	@GetMapping(value = "/paketi_clana/{id}")
	public KupljeniPaketiDTO listaPaketaClana(@PathVariable Long id) {
		return clanService.paketiClana(id);
	}

	@GetMapping("/prebroj")
	public long prebroj() {
		return clanService.countByIme("Jack");
	}

}
