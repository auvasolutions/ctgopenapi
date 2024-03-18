package com.auvasolutions.ctgopen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auvasolutions.ctgopen.model.Member;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findByEmail(String email);
}
