package com.excelr.ExcelrAugHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.Dept;
import com.excelr.ExcelrAugHibernate.entity.Employee;

public class FetchTypeDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();
    	Transaction tx=session1.beginTransaction();   //for executing DML queries
    	
    	Dept dept1=session1.get(Dept.class, 1);
    	//System.out.println(dept1);
    	
    	for(Employee emp:dept1.getEmps())
    	{
    		System.out.println(emp.getEname());
    	}
    	
    	
    	
    	
    	session1.close();
    	factory.close();

    }
}
