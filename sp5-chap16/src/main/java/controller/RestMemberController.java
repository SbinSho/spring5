package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.DuplicateMemberException;
import spring.Member;
import spring.MemberDao;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@RestController
public class RestMemberController {

	private MemberDao memberDao;
	private MemberRegisterService registerServce;  
	
	@GetMapping("api/members")
	public List<Member> members(){
		return memberDao.selectAll();
	}
	
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException{
		Member member = memberDao.selectById(id);
		
		if(member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setRegisterServce(MemberRegisterService registerServce) {
		this.registerServce = registerServce;
	}
	
	@PostMapping("/api/members")
	public void newMember(@RequestBody @Valid RegisterRequest regReq, Errors errors, HttpServletResponse response) throws IOException {
	
		try {
			new RegisterRequestValidator().validate(regReq, errors);
			if(errors.hasErrors()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			Long newMemberId = registerServce.regist(regReq);
			response.setHeader("Location", "/api/members/" + newMemberId);
			response.setStatus(HttpServletResponse.SC_CREATED);
					
		} catch (DuplicateMemberException dupEx) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}
		
	}
	
	
	 
}
