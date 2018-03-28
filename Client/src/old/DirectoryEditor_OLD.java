package old;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Employee;

public class DirectoryEditor_OLD {
	static Scanner in;
	DirectoryProxy dp = new DirectoryProxy();
	MainDirectory company = new MainDirectory();

	public static void main(String[] s) throws FileNotFoundException {
		in = new Scanner(new File("testFile.txt"));
		DirectoryEditor_OLD d = new DirectoryEditor_OLD();
		d.play();
	}

	public void play() {

		// createPeoples(dp);
		// company.transfer( dp.printJsonFormatArrList());
		// company.print();
		// company.clear();
		// company.print();
		// System.out.println();
		// createPeoples(dp);
		// company.transfer( dp.printJsonFormatArrList());
		// company.print();

		System.out.println("Lab 7 client. Enter commands (-1 to quit):");
		String input = in.nextLine();
		while (!input.equals("-1")) {
			userInputParse(input);
			input = in.nextLine();
		}
	}

	// public static void createPeoples(DirectoryProxy dp){
	// dp.add(new Employee("Adam","mast","EE",32444));
	// dp.add(new Employee("Sarah","alast","CF",63254));
	// dp.add(new Employee("Laura","blast","SF",63254));
	// dp.add(new Employee("Henry","clast","NF",63254));
	// }

	public void userInputParse(String input) {
		String[] parsed = input.split(" ");
		switch (parsed[0]) {
		case "ADD":
			String[] employee = in.nextLine().trim().split(" ");
			while (!employee[0].equals("END") && employee.length == 4) {
				dp.add(new Employee(employee[0], employee[1], employee[2], employee[3]));
				employee = in.nextLine().split(" ");
			}
			company.transfer(dp.printJsonFormatArrList());
			dp.clear();
			break;
		case "PRINT":
			company.print();
			break;
		case "CLR":
			company.clear();
			break;
		default:
			break;

		}
	}
}