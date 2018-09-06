package com.sino.base.lambda;

import java.util.ArrayList;
import java.util.List;


public class Article<T> {
	 
    private  String title;
    private  String author;
    private  List<T> tags = new ArrayList<>();
    

    public Article() {
		super();
	}

	public Article(String title, String author, List<T> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<T> getTags() {
        return tags;
    }

	@Override
	public String toString() {
		return "Article [title=" + title + ", author=" + author + ", tags=" + tags + "]";
	}

	
    
    
}