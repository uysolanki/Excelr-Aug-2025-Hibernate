package com.excelr.ExcelrAugHibernate;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.ExcelrAugHibernate.entity.Dept;
import com.excelr.ExcelrAugHibernate.entity.Employee;

public class OneToManyDemo 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
    	Session session1=  factory.openSession();
    	Transaction tx=session1.beginTransaction();   //for executing DML queries
    	
    	Employee e1=Employee.builder()
    			.ename("Alice")
    			.sal(800.0)
    			.build();
    	
    	Employee e2=Employee.builder()
    			.ename("Ben")
    			.sal(900.0)
    			.build();
    	
    	Employee e3=Employee.builder()
    			.ename("Chris")
    			.sal(500.0)
    			.build();
    	
    	Employee e4=Employee.builder()
    			.ename("David")
    			.sal(400.0)
    			.build();
    	
    	
    	Dept d1=Dept.builder()
    			.dname("IT")
    			.city("Pune")
    			.emps(new ArrayList(Arrays.asList(e1,e2)))
    			.build();
    	
    	Dept d2=Dept.builder()
    			.dname("Sales")
    			.city("Delhi")
    			.emps(new ArrayList(Arrays.asList(e3,e4)))
    			.build();
    	
    	session1.save(d1);
    	session1.save(d2);
    	
    	tx.commit();
    	
    	session1.close();
    	factory.close();

    }
}
