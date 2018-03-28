import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DirectoryProxy {

	public static String recieveJson(String json) {

		String command = json.substring(0, json.indexOf(" "));

		String response = "";

		switch (command.toUpperCase()) {
		case "CLEAR":
			Driver.remoteDirectory.clear();
			if (Driver.remoteDirectory.isEmpty()) {
				response = "Server directory has been cleared.";
			} else {
				response = "There was an error clearing the server directory.";
			}
			break;

		case "PRINT":
			response = Driver.remoteDirectory.print();
			break;

		case "ADD":
			Gson g = new Gson();
			String data = json.substring(json.indexOf(" ") + 1, json.length());
			ArrayList<Employee> newEmployees = (g.fromJson(data, new TypeToken<Collection<Employee>>() {
			}.getType()));
			Driver.remoteDirectory.add(newEmployees);
			response = "Server directory size is now " + Driver.remoteDirectory.getSize();
			break;
		default:
			response = "ERROR!";
		}
		return response;

	}

}
