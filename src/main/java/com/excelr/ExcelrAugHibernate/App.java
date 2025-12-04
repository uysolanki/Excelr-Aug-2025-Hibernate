package com.excelr.ExcelrAugHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();
    	Transaction tx=session1.beginTransaction();   //for executing DML queries
    	
    	Student s1=new Student(45,"Rohit",87.5);
    	session1.save(s1);
    	tx.commit();
    	
    	System.out.println("Record Inserted");
    	
    	
    	session1.close();
    	factory.close();

    }
}
