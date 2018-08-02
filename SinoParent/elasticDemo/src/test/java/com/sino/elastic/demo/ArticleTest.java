package com.sino.elastic.demo;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sino.elastic.bean.Article;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleTest {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void batchInsertArticle() {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 100; i++) {
			long nextLong = RandomUtils.nextLong();

			Article article = new Article();
			article.setContent("今夕何夕兮搴洲中流。\r\n" + 
					"今日何日兮得与王子同舟。\r\n" + 
					"蒙羞被好兮不訾诟耻。\r\n" + 
					"心几烦而不绝兮得知王子。\r\n" + 
					"山有木兮木有枝。\r\n" + 
					"心悦君兮君不知");
			article.setId(nextLong);
			article.setAbstracts("《越人歌》");
			article.setClickCount(nextLong);
			article.setPostTime(new Date());
			String chName = ChineseName.getChName();
			article.setTitle(chName);
			
			IndexQuery indexQuery = new IndexQuery();
			indexQuery.setIndexName("article_index");
			indexQuery.setObject(article);
			String index = elasticsearchTemplate.index(indexQuery);
			System.out.println(index);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("total time:"+(start-end));

	}
	
	
}
