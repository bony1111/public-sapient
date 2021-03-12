package com.sapient.assesment.FootballAssessemnt.controller;


import com.sapient.assesment.FootballAssessemnt.model.Country;
import com.sapient.assesment.FootballAssessemnt.model.Standing;
import com.sapient.assesment.FootballAssessemnt.model.Team;
import com.sapient.assesment.FootballAssessemnt.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootBallController {
	
	@Autowired
	FootballService footballService;
	
	@GetMapping(value="/country/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Country getCountry(@PathVariable("name") String name) {
		return footballService.getCountry(name);
	}
	
		
	@GetMapping(value="/team",produces=MediaType.APPLICATION_JSON_VALUE)
	public Team getTeam(@RequestParam("team_name") String name, @RequestParam("league_Id") Integer id) {
		return footballService.getTeam(name, id);
	}
	
	@GetMapping(value="/standing",produces=MediaType.APPLICATION_JSON_VALUE)
	public Standing getStanding(@RequestParam("country_name") String countryName,
								@RequestParam("league_Id") Integer leagueId,
								@RequestParam("team_name") String teamName) {

				return footballService.getStanding(countryName, leagueId, teamName);
	}			
}

