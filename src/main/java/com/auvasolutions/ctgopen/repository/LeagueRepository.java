package com.auvasolutions.ctgopen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auvasolutions.ctgopen.model.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long>{

}

