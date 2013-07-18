package com.bhagyesh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.hibernate.*;

public class InsertRecords {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int choice;
		do {
			System.out
					.println("1>Insert Records \n2>Delete Records \n3> Update Records \n4> Read Records ");
			System.out.println("Enter Your choice : ");
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			String s = bufferRead.readLine();
			choice = Integer.parseInt(s);

			switch (choice) {
			case 1:
				System.out.println(" \nEnter First Name :");
				BufferedReader READFIRSTNAME = new BufferedReader(new InputStreamReader(System.in));
				String FIRSTNAME = READFIRSTNAME.readLine();
				System.out.println(" \nEnter Last Name :");
				BufferedReader READLASTNAME = new BufferedReader(new InputStreamReader(System.in));
				String LASTNAME = READLASTNAME.readLine();
				System.out.println(" \nEnter Cell Phone :");
				BufferedReader READCELLPHONE = new BufferedReader(new InputStreamReader(System.in));
				String CELLPHONE = READCELLPHONE.readLine();
				insert(FIRSTNAME, LASTNAME, CELLPHONE);

				break;
			case 2:
				System.out.println(" Deletion :");
				delete();
				break;
			case 3:
				System.out.println(" \nEnter Employee Id :");
				int empid = input.nextInt();
				System.out.println(" \nEnter First Name :");
				String firstname = input.next();
				System.out.println(" \nEnter Last Name :");
				String lastname = input.next();
				update(empid, firstname, lastname);
				break;
			case 4:
				Readall();
				break;
			default:
				break;
			}

		} while (choice <= 4);
	}

	public static void insert(String firstname, String lastname, String cellno) {
		Employee emp = new Employee();
		emp.setFirstname(firstname);
		emp.setLastname(lastname);
		emp.setCell_phone(cellno);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp);
		System.out.println("Inserted SuccessFully");
		session.getTransaction().commit();
		session.close();
	}

	public static void delete() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = (Employee) session.load(Employee.class, 3);
		session.delete(emp);
		System.out.println("Deleted Successfully");
		session.getTransaction().commit();
	}

	public static void update(int empid, String firstname, String lastname) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, 3);
		emp.setFirstname("Amin Apar");
		System.out.println("Update Successfully");
		session.getTransaction().commit();
	}

	public static void Readall() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List<Employee> emp = query.list();
		System.out.println("-------------------------------EMPLOYEE DETAILS---------------------------------\n");
		for (Employee employee : emp) {
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("Roll Number: " + employee.getId()
					+ ", Student Name: " + employee.getFirstname()
					+ ", Lastname: " + employee.getLastname() + " Cell Phone :"
					+ employee.getCell_phone());
			System.out
					.println("---------------------------------------------------------------------------------------------------------------");
		}
		session.getTransaction().commit();
	}
}
