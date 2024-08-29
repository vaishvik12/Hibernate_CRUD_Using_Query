package com.client;

import java.util.Scanner;

import com.CRUDImpl.CRUDImpl;

public class test {
	public static void main(String[] args) {

		boolean loop = true;

		while (loop) {
			System.out.println("To insert data press 1:" + "\nTo update data press 2:" + "\nTo delete data press 3:"
					+ "\nTo display data press 4:" + "\nTo exit press 5");
			CRUDImpl ci = new CRUDImpl();
			Scanner scanner = new Scanner(System.in);

			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				ci.insertData();
				System.out.println("Data Inserted!");
				break;
			}
			case 2: {
				ci.updateData();
				System.out.println("Data Inserted!");
				break;
			}
			case 3: {
				ci.deleteData();
				System.out.println("Data Deleted!");
				break;
			}
			case 4: {
				System.out.println("\n");
				ci.selectData();
				System.out.println("\n");
				break;
			}
			case 5: {
				loop = false;
				break;
			}
			default: {
				System.out.println("Some error occured!");
				break;
			}
			}
		}
	}
}
