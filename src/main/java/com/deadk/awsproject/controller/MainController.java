package com.deadk.awsproject.controller;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.deadk.awsproject.Quickstart;

@Controller
public class MainController {

	
	@GetMapping("/")
	public String home(Model m) {
		return "home";
		
	}
	
	@GetMapping("/admin")
	public String admin(Model m) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername(); //get logged in username
			
	    m.addAttribute("username", name);
		
		return "admin";
		
	}
	
	
	@PostMapping("/upload-file")
	@ResponseBody
	public String saveNews(@RequestParam("file") MultipartFile file,Model m) throws IOException {

		try {
		String result = Quickstart.UploadFile(file);
		return result;
		}
		catch(Exception ex){
			return "failed";
		}
	}
	
}
