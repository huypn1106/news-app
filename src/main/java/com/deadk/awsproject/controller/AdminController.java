package com.deadk.awsproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deadk.awsproject.model.Article;
import com.deadk.awsproject.model.DefaultPage;
import com.deadk.awsproject.service.ArticleService;
import com.deadk.awsproject.service.DefaultPageService;

@Controller
public class AdminController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private DefaultPageService defaultPageService;
	
	@GetMapping("/list-article-admin")
	public String listArticle(Model m) {
		
		List<Article> list= articleService.findAll();
		
		m.addAttribute("articles", list);
		
		return "list-article-admin";
	}
	
	
	@GetMapping("/list-default-admin")
	public String listDefault(Model m) {
		
		List<DefaultPage> list= defaultPageService.findAll();
		
		m.addAttribute("defaults", list);
		
		return "list-default-admin";
	}
	
}
