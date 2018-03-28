import java.util.ArrayList;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainDirectory {
	ArrayList<Employee> directory;
	Gson g;

	public MainDirectory() {
		directory = new ArrayList<Employee>();
		g = new Gson();
	}

	public void add(ArrayList<Employee> newEntries) {
		directory.addAll(newEntries);
		directory.sort(new CompareEmployees());
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		for (Employee person : directory) {
			sb.append(person.toString() + System.lineSeparator());
		}
		return sb.toString();
	}

	public void clear() {
		directory.clear();
	}

	public void transfer(String json) {
		ArrayList<Employee> entries = (g.fromJson(json, new TypeToken<ArrayList<Employee>>() {
		}.getType()));
		add(entries);
	}

	private class CompareEmployees implements Comparator<Employee> {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * 
		 * @return < 0 if o1 comes before o2 0 if o1 == o2 > 0 if o2 comes after o1
		 */
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getLastName().compareTo(o2.getLastName());
		}

	}

	public boolean isEmpty() {
		return directory.isEmpty();
	}

	public int getSize() {
		return directory.size();
	}
}