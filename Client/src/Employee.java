
public class Employee implements Comparable<Object> {

	private String _firstName;
	private String _lastName;
	private String _phoneNumber;
	private String _department;
	private String _title;
	private String _gender;

	public Employee(String fName, String lName, String phoneNumber, String department, String title, String gender) {
		_firstName = fName;
		_lastName = lName;
		_phoneNumber = phoneNumber;
		_department = department;
		_title = title;
		_gender = gender;
	}

	public String toString() {
		return "NAME: " + _title + _firstName + " " + _lastName + ". PHONE: " + _phoneNumber + ". DEPT: " + _department + ". GENDER: " + _gender;
	}

	@Override
	public int compareTo(Object arg0) {
		if (arg0 instanceof Employee) {
			Employee other = (Employee) arg0;
			return _lastName.compareTo(other.getLastName());
		}
		return 0;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String _firstName) {
		this._firstName = _firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String _lastName) {
		this._lastName = _lastName;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String _phoneNumber) {
		this._phoneNumber = _phoneNumber;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String _department) {
		this._department = _department;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String _title) {
		this._title = _title;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String _gender) {
		this._gender = _gender;
	}

}
