package com.auvasolutions.ctgopen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auvasolutions.ctgopen.exception.ResourceNotFoundException;
import com.auvasolutions.ctgopen.model.League;
import com.auvasolutions.ctgopen.repository.LeagueRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ctgopenapi/v1/")
public class LeagueController {

	@Autowired
	private LeagueRepository leagueRepository;
	
	// get all leagues
	@GetMapping("/leagues")
	public List<League> getAllLeagues(){
		return leagueRepository.findAll();
	}		
	
	// create league rest api
	@PostMapping("/league")
	public League createLeague(@RequestBody League league) {
		return leagueRepository.save(league);
	}
	
	// get league by id rest api
	@GetMapping("/league/{id}")
	public ResponseEntity<League> getLeagueById(@PathVariable Long id) {
		League league = leagueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("League not exist with id :" + id));
		return ResponseEntity.ok(league);
	}
	
	// update league rest api
	
	@PutMapping("/league/{id}")
	public ResponseEntity<League> updateLeague(@PathVariable Long id, @RequestBody League leagueDetails){
		League league = leagueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("League not exist with id :" + id));
		
		league.setName(leagueDetails.getName());
		
		League updatedLeague = leagueRepository.save(league);
		return ResponseEntity.ok(updatedLeague);
	}
	
	// delete league rest api
	@DeleteMapping("/league/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLeague(@PathVariable Long id){
		League league = leagueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("League not exist with id :" + id));
		
		leagueRepository.delete(league);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
