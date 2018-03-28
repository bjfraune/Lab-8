package old;
import java.util.ArrayList;
import com.google.gson.Gson;

import Employee;

public class DirectoryProxy {
	ArrayList<Employee> emp = new ArrayList<Employee>();
	Gson proxy = new Gson();

	public boolean add(Employee E) {
		return emp.add(E);
	}

	public void print() {
		System.out.println(emp.toString());
	}

	public void clear() {
		emp.clear();
	}

	public String printJsonFormatArrList() {
		return proxy.toJson(emp);
	}
}