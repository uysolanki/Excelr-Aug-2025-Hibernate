package com.excelr.ExcelrAugHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.Student;

public class LoadDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();  //session is empty
    	
    	Student stud1=session1.load(Student.class,77);	//database query : NO
    	System.out.println("Hiiii");
    	
    	
    	System.out.println(stud1.getRno());				//database query : NO	
    	System.out.println("Bye");
    	
    	System.out.println(stud1.getSname());			//database query : YES
    	
    	
    	session1.close();
    	factory.close();

    }
}
