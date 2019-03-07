package com.deadk.awsproject.controller;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.deadk.awsproject.model.DefaultPage;
import com.deadk.awsproject.service.DefaultPageService;

@Controller
public class DefaultPageController {

	@Autowired
	private DefaultPageService defaultPageService;
	
	
	
	@GetMapping("/default")
	public String article(@RequestParam int id, Model m) {
		DefaultPage page = defaultPageService.find(id);
		m.addAttribute("defaultPage", page);
		if(page.getName().equals("home"))
				return "home";
		return "default";
	}
	
	
	
	@GetMapping("/edit-default")
	public String editArticle(@RequestParam int id, Model m) {
		
		DefaultPage page = defaultPageService.find(id);
		m.addAttribute("defaultpage", page);
		
		return "edit-default-page";
	}
	
	@PostMapping("/save-default-page")
	public String saveArticle(@ModelAttribute DefaultPage defaultPage, BindingResult bindingResult,Model m) {
		
		Date date = new Date();
		
		defaultPage.setLastModified(new Timestamp(date.getTime()));
		defaultPageService.save(defaultPage);
		
		m.addAttribute("defaultPage", defaultPage);
		return "default";
	}
}
