package com.excelr.ExcelrAugHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.Student;

public class GetDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();  //session is empty
    	
    	Student stud1=session1.get(Student.class,5);	//database query : YES
    	System.out.println("First Time "+ stud1);
    	
    	Student stud2=session1.get(Student.class, 2);	//database query : YES
    	System.out.println("Second Time "+ stud2);
    	
    	System.out.println(stud1==stud2);  //false
    	session1.close();
    	factory.close();

    }
}
