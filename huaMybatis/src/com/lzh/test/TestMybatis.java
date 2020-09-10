package com.lzh.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lzh.pojo.Category;

public class TestMybatis {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource="mybatis-config.xml";
		InputStream input=Resources.getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(input);
		SqlSession session=factory.openSession();
		List<Category> cs=session.selectList("listCategory");
		cs.forEach(p->System.out.println(p.getName()));
		
	}

}
