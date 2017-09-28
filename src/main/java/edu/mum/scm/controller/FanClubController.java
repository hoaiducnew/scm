package edu.mum.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.scm.service.FanclubService;

@Controller
@RequestMapping(value="/fanclubs")
public class FanClubController {
	
	@Autowired
	FanclubService fanclubService;
	
	

}
