package com.excelr.ExcelrAugHibernate;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.Actor;
import com.excelr.ExcelrAugHibernate.entity.Movie;

/**
 * Hello world!
 *
 */
public class ManyToManyDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
  
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction();		//DML Queries;
    	
    	
    	
    	Movie m1=Movie.builder()
    			.mname("Jawan")
    			.ryear(2025)
    			.build();
    	
    	Movie m2=Movie.builder()
    			.mname("CE")
    			.ryear(2010)
    			.build();
    	
    	Actor a1=Actor.builder()
    			.aname("SRK")
    			.age(60)
    			.portfolio(new ArrayList(Arrays.asList(m1,m2)))
    			.build();
    	
    	Actor a2=Actor.builder()
    			.aname("DP")
    			.age(40)
    			.portfolio(new ArrayList(Arrays.asList(m2)))
    			.build();
    	
    	session1.save(a1);
    	session1.save(a2);
    
    	tx.commit();
    	
    	session1.close();
    	factory.close();

    }
}
