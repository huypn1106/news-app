package com.deadk.awsproject.dao;
import com.deadk.awsproject.model.Article;


import org.springframework.data.repository.CrudRepository;
public interface ArticleRepository extends CrudRepository<Article,Integer>{

}
