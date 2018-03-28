import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {

	JTextField fNameBox = new JTextField(20);
	JTextField lNameBox = new JTextField(20);
	JTextField phoneBox = new JTextField(10);
	JTextField departmentBox = new JTextField(50);
	JFrame frame = new JFrame();
	JPanel fields = new JPanel();
	JPanel buttons = new JPanel();

	JButton submit = new JButton("Submit");
	JButton exit = new JButton("Exit");

	JLabel firstName = new JLabel("First Name");
	JLabel lastName = new JLabel("Last Name");
	JLabel phone = new JLabel("Phone Number");
	JLabel department = new JLabel("Department");
	JButton clear = new JButton("Clear");

	ButtonGroup gender = new ButtonGroup();

	JRadioButton male = new JRadioButton("Male");
	JRadioButton female = new JRadioButton("Female");
	JRadioButton other = new JRadioButton("Other");
	JPanel radioButtons = new JPanel(new GridLayout(0, 1));

	String[] titles = { "Mr. ", "Ms. ", "Mrs. ", "Dr. ", "Col. ", "Prof. " };
	JComboBox<String> titleList = new JComboBox<>(titles);

	public GUI() {
		createComponents();
	}

	public void createComponents() {

		setLayout(new GridLayout(6, 2));
		setTitle("New Employee");
		setSize(400, 400);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gender.add(male);
		gender.add(female);
		gender.add(other);

		radioButtons.add(male);
		radioButtons.add(female);
		radioButtons.add(other);

		add(firstName);
		add(fNameBox);
		add(lastName);
		add(lNameBox);
		add(phone);
		add(phoneBox);
		add(department);
		add(departmentBox);
		add(radioButtons);
		add(titleList);
		add(submit);
		add(exit);

		frame.add(fields, BorderLayout.CENTER);
		frame.add(buttons, BorderLayout.SOUTH);

		setVisible(true);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean errorTriggered = false;

				if (fNameBox.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "First Name can't be null!", "Error", JOptionPane.ERROR_MESSAGE);
					errorTriggered = true;
				} else if (lNameBox.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Last name can't be null!", "Error", JOptionPane.ERROR_MESSAGE);
					errorTriggered = true;
				} else if (phoneBox.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Phone Number can't be null!", "Error", JOptionPane.ERROR_MESSAGE);
					errorTriggered = true;
				} else if (departmentBox.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Department can't be null!", "Error", JOptionPane.ERROR_MESSAGE);
					errorTriggered = true;
				} else if (gender.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "Gender can't be null!", "Error", JOptionPane.ERROR_MESSAGE);
					errorTriggered = true;
				}

				String selectedGender;

				if (male.isSelected()) {
					selectedGender = "Male";
				} else if (female.isSelected()) {
					selectedGender = "Female";
				} else {
					selectedGender = "Other";
				}

				Employee employee = new Employee(fNameBox.getText(), lNameBox.getText(), phoneBox.getText(),
						departmentBox.getText(), titleList.getSelectedItem().toString(), selectedGender);

				// System.out.println(employee.toString());
				if (!errorTriggered) {
					DirectoryEditor.addEntry(employee);
					fNameBox.setText("");
					lNameBox.setText("");
					departmentBox.setText("");
					phoneBox.setText("");
					gender.clearSelection();
				}

			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.exit(0);

				// with dispose, the program continues to run after the window is closed
				dispose();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
