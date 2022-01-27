package com.board.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Service
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
 
    @Autowired
    private DataSource dataSource;
    
    @Autowired private 
    SqlSessionFactory sqlSessionFactory;
    
    @Test
    public void testConnection() {
        
        try(
                Connection con = dataSource.getConnection();
                SqlSession session = sqlSessionFactory.openSession();
            
            ){
            
                System.out.println("con = " + con);
                System.out.println("session = " + session);
            
            } catch(Exception e) {
            
                e.printStackTrace();
            
            }
        
    }
    
}