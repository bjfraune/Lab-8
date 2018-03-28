import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class DirectoryEditor {

	private static final String BR = System.lineSeparator();
	private static Gson g;
	private static ArrayList<Employee> localDirectory = new ArrayList<>();
	private static Scanner stdIn;

	public static void main(String[] args) throws InterruptedException {

		g = new Gson();
		stdIn = new Scanner(System.in);

		System.out.println("Welcome to the Client Directory Device." + BR);

		String inputSelection = "";
		while (!inputSelection.equals("0")) {

			System.out.println("To quit the program now, enter \"0\".");
			System.out.println("To read test data from a file, enter \"1\". (NOT IMPLEMENTED)");
			System.out.println("To use console input/GUI, enter \"2\".");
			System.out.print(BR + "Please make your selection now: ");

			inputSelection = stdIn.nextLine();

			switch (inputSelection) {
			case "0":
				break;

			case "1":
				// does nothing
				readFile();
				break;

			case "2":
				readConsole();
				break;

			default:
				System.out.println("Your input did not match a recognized command. Please try again." + BR);
				break;
			}
		}

		System.out.println("LOCAL DIRECTORY SIZE: " + localDirectory.size());

		stdIn.close();
	}

	public static void addEntry(Employee e) {
		localDirectory.add(e);
	}

	private static void readConsole() throws InterruptedException {

		String inputSelection = "";
		while (!inputSelection.equalsIgnoreCase("EXIT")) {

			System.out.println(BR + "To quit the program now, type \"EXIT\".");
			System.out.println("To add one or more employees to the remote directory, type \"ADD\".");
			System.out.println("To print the remote directory, type \"PRINT\".");
			System.out.println("To empty the remote directory, type \"CLEAR\".");

			System.out.print(BR + "What would you like to do? : ");

			inputSelection = stdIn.nextLine();

			switch (inputSelection.toUpperCase()) {

			case "EXIT":
				break;

			case "ADD": {
				GUI userInterface = new GUI();
				while (userInterface.isDisplayable()) {
					// prevent the program from proceeding while the gui is being used
					Thread.sleep(1);
				}
				if (!localDirectory.isEmpty()) {
					System.out.println(BR + "*** Posting new employees to the server. ***");
					String response = Client.postToServer("ADD " + g.toJson(localDirectory));
					System.out.println("*** Posted. Server Response: " + response);
				}
				break;
			}
			case "PRINT": {
				String response = Client.postToServer("PRINT");
				System.out.println(BR + "*** SERVER RESPONSE ***");
				printJson(response);
				break;
			}
			case "CLEAR": {
				String response = Client.postToServer("CLEAR");
				System.out.println(BR + response);
				break;
			}
			default: {
				System.out.println("Your input did not match a recognized command. Please try again.");
				break;
			}
			}
		}

	}

	private static void readFile() {
		// there was not an updated test file to read for this lab
	}

	private static void printJson(String json) {
		// need to decode json first...
		System.out.println(json);
	}

}
