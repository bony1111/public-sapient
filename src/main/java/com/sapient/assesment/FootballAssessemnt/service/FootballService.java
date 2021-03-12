package com.sapient.assesment.FootballAssessemnt.service;

import com.sapient.assesment.FootballAssessemnt.model.Country;
import com.sapient.assesment.FootballAssessemnt.model.League;
import com.sapient.assesment.FootballAssessemnt.model.Standing;
import com.sapient.assesment.FootballAssessemnt.model.Team;
import com.sapient.assesment.FootballAssessemnt.repository.CountryRepository;
import com.sapient.assesment.FootballAssessemnt.repository.LeagueRepository;
import com.sapient.assesment.FootballAssessemnt.repository.StandingRepository;
import com.sapient.assesment.FootballAssessemnt.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballService {

	@Autowired
	private CountryRepository countryRepository;
    @Autowired
	private LeagueRepository leagueRepository;
    @Autowired
	private TeamRepository teamRepository;
	@Autowired
	private StandingRepository standingRepository;
	
	public Standing getStanding(String countryName, Integer leagueId, String teamName) {
		Integer teamId = teamRepository.getTeamByName(teamName, leagueId).getTeamId();
		return standingRepository.getStanding(leagueId, teamId);
	}
	
	public Country getCountry(String countryName) {
		return countryRepository.getCountryByName(countryName);
	}
	
	public Team getTeam(String teamName, Integer leagueId) {
		return teamRepository.getTeamByName(teamName, leagueId);
	}
	
	public League getLeague(String name, Integer countryId) {
		return leagueRepository.getLeagueByName(name, countryId);
	}
}
