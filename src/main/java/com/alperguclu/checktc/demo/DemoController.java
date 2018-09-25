package com.alperguclu.checktc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alperguclu.checktc.Client;

@Controller
public class DemoController {
	@Autowired
	private Client client;
	
	@GetMapping("/demo")
	public String demo(Model model) {
		model.addAttribute("verificationInfo", new VerificationInfo());
		return "demoform";
	}
	
	@PostMapping("/demo")
	public String verify(@ModelAttribute VerificationInfo verificationInfo) {
		boolean result = client.check(verificationInfo.getName(), verificationInfo.getSurname(), verificationInfo.getYearOfBirth(), verificationInfo.getTc());
		verificationInfo.setResult(result);
		return "verificationresult";
	}
}
