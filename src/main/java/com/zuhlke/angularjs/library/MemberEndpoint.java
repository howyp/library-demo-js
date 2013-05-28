package com.zuhlke.angularjs.library;

import java.util.Collections;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zuhlke.angularjs.model.Member;

@Path("/members") 
public class MemberEndpoint {
	
	final Logger logger = LoggerFactory.getLogger(MemberEndpoint.class);

	@Inject 
	private MemberService memberService;
	
	@GET @Produces(MediaType.APPLICATION_JSON)
	public Map<String, ? extends Object> getMembers() {
		return Collections.singletonMap("users", memberService.getMembers());
	}

	@Path("/{membershipNumber}")
	@GET @Produces(MediaType.APPLICATION_JSON)
	public Member getMember(@PathParam("membershipNumber") String membershipNumber) {
		return memberService.getMemberByMembershipNumber(membershipNumber);
	}
		

	
}

