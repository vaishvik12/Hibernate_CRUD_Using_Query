package com.CRUDImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.CRUD.CRUD;
import com.configuratio.Configuraton;
import com.model.Customers;

public class CRUDImpl implements CRUD {

	@Override
	public void insertData() {
		Scanner scanner = new Scanner(System.in);
		Session session = Configuraton.startSession().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Enter the name of the Customer: ");
		String name = scanner.nextLine();

		System.out.println("Enter the Email of the Customer: ");
		String Email = scanner.nextLine();

		System.out.println("Enter the Phone Number of the Customer: ");
		int number = scanner.nextInt();

		Customers cust = new Customers(name, Email, number);
		session.save(cust);
		tx.commit();

	}

	@Override
	public void deleteData() {
		Scanner scanner = new Scanner(System.in);
		Session session = Configuraton.startSession().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter the id of the Customer you want to delete: ");
		int id = scanner.nextInt();

		scanner.nextLine();
		Query deleteQuery = session.createQuery("delete from Customers where id = :sid");
		deleteQuery.setParameter("sid", id);
		int delete = deleteQuery.executeUpdate();
		System.out.println("Querry deleted: " + delete);
		tx.commit();
	}

	@Override
	public void selectData() {
		Scanner scanner = new Scanner(System.in);
		Session session = Configuraton.startSession().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("To display all details press 1:" + "\nTo display details of a particular customer press 2");
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1: {
			Query selectQuery = session.createQuery("from Customers");
//			for(Customers each :) {
//				
//			}
			List<Customers> list = selectQuery.getResultList();
			for(Customers s:list)
			{
				System.out.println(s);
			}
			break;
		}
		case 2: {
			System.out.println("Enter the id of the Customers whos detail you want to display: ");
			int id = scanner.nextInt();
			scanner.nextLine();

			Query selectQuery = session.createQuery("from Customers where id =: sId");
			selectQuery.setParameter("sId", id);
			Customers cust = (Customers)selectQuery.getSingleResult();
			System.out.println(cust);
			tx.commit();
			break;
		}
		default:{
			System.out.println("Some error occured!");
			break;
		}

		}
	}

	@Override
	public void updateData() {

		Scanner scanner = new Scanner(System.in);
		Session session = Configuraton.startSession().openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter the id of the Customer you want to update: ");
		int id = scanner.nextInt();

		scanner.nextLine();

		System.out.println("To udpate name press 1" + "\nTo update Email press 2" + "\nTo update Phone number press 3");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1: {
			System.out.println("Enter new name: ");
			String name = scanner.nextLine();
			Query updateNameQuery = session.createQuery("update Customers set name=:cName where id=:cId");
			updateNameQuery.setParameter("cName", name);
			updateNameQuery.setParameter("cId", id);

			
			int update = updateNameQuery.executeUpdate();
			System.out.println(update);
			tx.commit();
			break;
		}
		case 2: {
			System.out.println("Enter the new Email: ");
			String email = scanner.nextLine();
			Query updateEmailQuery = session.createQuery("update Customers set email=:cEmail where id =:cId");
			updateEmailQuery.setParameter("cEmail", email);
			updateEmailQuery.setParameter("cId", id);
			int update = updateEmailQuery.executeUpdate();
			System.out.println(update);
			tx.commit();
			break;
		}
		case 3: {
			System.out.println("Enter the new phone number: ");
			int number = scanner.nextInt();
			Query updateEmailQuery = session.createQuery("update Customers set number =: cNumber where id = :sId");
			updateEmailQuery.setParameter("cNumber", number);
			updateEmailQuery.setParameter("cId", id);
			int update = updateEmailQuery.executeUpdate();
			System.out.println(update);
			tx.commit();
			break;
		}
		default: {
			System.out.println("invalid choice!");
			break;
		}
		}

	}

}
