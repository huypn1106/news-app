package com.deadk.awsproject.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deadk.awsproject.Quickstart;
import com.deadk.awsproject.model.Article;
import com.deadk.awsproject.service.ArticleService;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	
	
	@GetMapping("/new-article")
	public String createArticle() {
		return "new-article";
	}
	
	@PostMapping("/save-article")
	public String saveArticle(@ModelAttribute Article article, BindingResult bindingResult,Model m) {
		
		if(!article.getTempFile().isEmpty())
		{
			String result = Quickstart.UploadFile(article.getTempFile());
			article.setImg(result);
		}
		
		Date date = new Date();
		article.setDateCreated(new Timestamp(date.getTime()));
		articleService.save(article);
		
		m.addAttribute("article", article);
		return "article";
	}
	
	
	@GetMapping("/edit-article")
	public String editArticle(@RequestParam int id, Model m) {
		
		Article article = articleService.find(id);
		m.addAttribute("article", article);
		
		return "new-article";
	}
	
	
	@GetMapping("/delete-article")
	public String deleteArticle(@RequestParam int id, Model m) {
		
		articleService.delete(id);
		
		return "redirect:/list-article-admin";
	}
	
	
	@GetMapping("/article")
	public String article(@RequestParam int id, Model m) {
		Article article = articleService.find(id);
		article.setViewCount(article.getViewCount() + 1);
		articleService.save(article);
		m.addAttribute("article", article);
		
		
		List<Article> hotlist= articleService.findAll();
		hotlist = hotlist.stream().sorted(((p1,p2) -> p2.getViewCount() - p1.getViewCount())).collect(Collectors.toList());
		hotlist = hotlist.stream().limit(5).collect(Collectors.toList());
		
		m.addAttribute("hotlist", hotlist);
	
		List<Article> recentlist= articleService.findAll();
		recentlist = recentlist.stream().sorted((p1,p2) -> p2.getDateCreated().compareTo(p1.getDateCreated())).collect(Collectors.toList());
		recentlist = recentlist.stream().limit(5).collect(Collectors.toList());
		
		m.addAttribute("recentlist", recentlist);
		
		return "article";
	}
	
	
	@GetMapping("/articles")
	public String articles(Model m) {
		
		List<Article> list= articleService.findAll();
		
		m.addAttribute("articles", list);
		
		return "articles";
	}
	
	
}
