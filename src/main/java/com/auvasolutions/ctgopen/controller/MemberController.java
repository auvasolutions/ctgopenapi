package com.auvasolutions.ctgopen.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auvasolutions.ctgopen.exception.ResourceNotFoundException;
import com.auvasolutions.ctgopen.model.Member;
import com.auvasolutions.ctgopen.repository.MemberRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ctgopenapi/v1/")
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	// get all members
	@GetMapping("/members")
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}		
	
	// create member rest api
	@PostMapping("/member")
	public Member createMember(@RequestBody Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberRepository.save(member);
	}
	
	// get member by id rest api
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member not exist with id :" + id));
		return ResponseEntity.ok(member);
	}
	
	// update member rest api
	
	@PutMapping("/member/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails){
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member not exist with id :" + id));
		
		member.setFirstName(memberDetails.getFirstName());
		member.setLastName(memberDetails.getLastName());
		member.setEmail(memberDetails.getEmail());
		
		Member updatedMember = memberRepository.save(member);
		return ResponseEntity.ok(updatedMember);
	}
	
	// delete member rest api
	@DeleteMapping("/member/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMember(@PathVariable Long id){
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member not exist with id :" + id));
		
		memberRepository.delete(member);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
    @PostMapping("/member/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<Member> userOptional = memberRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            Member user = userOptional.get();
            // Use a password encoder to compare the provided password with the hashed password in the database
            if (passwordEncoder. matches(password, user.getPassword())) {
            	return ResponseEntity.ok("Login successful");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

	
}
