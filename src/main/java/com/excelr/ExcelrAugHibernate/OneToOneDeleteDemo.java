package com.excelr.ExcelrAugHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.ChiefMinister;
import com.excelr.ExcelrAugHibernate.entity.State;
import com.excelr.ExcelrAugHibernate.entity.Student;

public class OneToOneDeleteDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();
    	Transaction tx=session1.beginTransaction();   //for executing DML queries
    	
    	State state1=session1.get(State.class, 1);
    	session1.remove(state1);
    	tx.commit();
    	
    	session1.close();
    	factory.close();

    }
}
