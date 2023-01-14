package org.capillary.controller;

import java.util.ArrayList;

import org.capillary.Iservice.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/capillary")
public class capillaryController {
@Autowired
private Iservice service;
@GetMapping("/start")
public String Start(Model m)
{
	ArrayList<Integer> li=service.start();
	m.addAttribute("list",li);
	m.addAttribute("result","Ready");
	return "home";
}
@GetMapping("/dice_count")
public String diceCount(Model m)
{
	ArrayList<Integer> li=service.dice_count();
	m.addAttribute("list",li);
	if(li.get(0)==100) {
		String result="Red won";
		m.addAttribute("result",result);
	}
	if(li.get(1)==100) {
		String result="Green won";
		m.addAttribute("result",result);
	}
	return "home";
}
}
