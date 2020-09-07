package com.lzh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lzh.pojo.Comment;
import com.lzh.pojo.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 一个简单的示例
		 * 
		 */
		System.out.println("*********************1");
		ApplicationContext context=new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		//ApplicationContext context=new ClassPathXmlApplicationContext(new String[] {""});
		User user=(User)context.getBean("user");
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		Comment comment =(Comment)context.getBean("comment");
		System.out.println(comment.getId());
		System.out.println(comment.getTitle());
		System.out.println(comment.getContent());
		
		
		/**
		 * 
		 * 依赖注入
		 */
		System.out.println("*********************2");
//		ApplicationContext context=new ClassPathXmlApplicationContext(new String[] {""});
		Comment userComment=(Comment) context.getBean("comment");
		System.out.println(userComment.getTitle());
		System.out.println(userComment.getContent());
		System.out.println(userComment.getUser().getName());
		System.out.println(userComment.getUser().getPassword());
		
		
		
		
		
		
	}
	

}
