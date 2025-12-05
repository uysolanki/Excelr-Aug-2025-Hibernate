package com.excelr.ExcelrAugHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.Student;

public class DeleteDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();  //session is empty
    	Transaction tx=session1.beginTransaction();
    	
    	Student stud1=session1.get(Student.class,1);	
    	session1.remove(stud1);
    	tx.commit();
    	
    	session1.close();
    	factory.close();

    }
}
