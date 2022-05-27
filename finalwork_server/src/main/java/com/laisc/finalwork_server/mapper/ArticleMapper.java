package com.laisc.finalwork_server.mapper;

import com.laisc.finalwork_server.entity.Article;
import com.laisc.finalwork_server.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    public List<Article> findAllArticle();
    public List<Article> findArticleById(int id);
    public int insertArticle(Article article);
    public int updateArticle(Article article);
    public int delArticle(int id);


}
