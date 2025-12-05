package com.excelr.ExcelrAugHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.ChiefMinister;
import com.excelr.ExcelrAugHibernate.entity.State;
import com.excelr.ExcelrAugHibernate.entity.Student;

public class OneToOneDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();
    	Transaction tx=session1.beginTransaction();   //for executing DML queries
    	
    	ChiefMinister cm1=new ChiefMinister();
    	cm1.setAge(55);
    	cm1.setCmname("Fadnavis");
    	
    	
    	ChiefMinister cm2=ChiefMinister.builder()
    			.age(60)
    			.cmname("Sharma")
    			.build();
    	
    	ChiefMinister cm3=ChiefMinister.builder()
    			.age(65)
    			.cmname("Patel")
    			.build();
    	
    	State s1=State.builder()
    			.sname("Maharashtra")
    			.capital("Mumbai")
    			.chiefMinister(cm1)
    			.build();
    	
    	State s2=State.builder()
    			.sname("Rajasthan")
    			.capital("Jaipur")
    			.chiefMinister(cm2)
    			.build();
    	
    	State s3=State.builder()
    			.sname("Gujarat")
    			.capital("Ahmedabad")
    			.chiefMinister(cm3)
    			.build();
    	
    	session1.save(s1);
    	session1.save(s2);
    	session1.save(s3);
    	tx.commit();
    	
    	session1.close();
    	factory.close();

    }
}
