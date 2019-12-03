package ua.nure.cs.skafa.usermanagement.domain.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPanel extends JPanel implements ActionListener {
	
	private MainFrame parent;
	private JPanel buttonPanel;
	private JPanel fieldPanel;
	private JButton cancelButton;
	private JButton okButton;
	private JTextField dayOfBirthField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	
	public AddPanel(MainFrame parent) {
		this.parent = parent;
		initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());
		this.add(getFieldPanel(), BorderLayout.NORTH);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
	}

	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getOkButton(), null);
			buttonPanel.add(getCancelButton(), null);
		}
		return buttonPanel;
	}

	private JButton getCancelButton() {
		if (cancelButton == null){
			cancelButton = new JButton();
			cancelButton.setText("Отмена");
			cancelButton.setName("CancelButton");
			cancelButton.setActionCommand("cancel");
			cancelButton.addActionListener(this);
		}
		return cancelButton;
	}

	private JButton getOkButton() {
	if (okButton == null){
		okButton = new JButton();
		okButton.setText("Добавить");
		okButton.setName("okButton");
		okButton.setActionCommand("ok");
		okButton.addActionListener(this);
	}
	return okButton;
}


	private JPanel getFieldPanel() {
		if (fieldPanel == null) {
			fieldPanel = new JPanel();
			fieldPanel.setLayout(new GridLayout(3, 2));
			addLabelField(fieldPanel, "Name", getFirstNameField());
			addLabelField(fieldPanel, "Last name", getLastNameField());
			addLabelField(fieldPanel, "Day of Birth", getDayOfBirthField());
		}
		return fieldPanel;
	}

	private JTextField getDayOfBirthField() {
		if (dayOfBirthField == null) {
			dayOfBirthField = new JTextField();
			dayOfBirthField.setName("dayOfBirthField");
		}
		return dayOfBirthField;
	}

	private JTextField getLastNameField() {
		if (lastNameField == null) {
			lastNameField = new JTextField();
			lastNameField.setName("lastNameField");
		}
		return lastNameField;
	}

	private void addLabelField(JPanel panel, String labelText, JTextField textField) {
		JLabel label = new JLabel(labelText);
		panel.add(label);
		panel.add(textField);
	}

	private JTextField getFirstNameField() {
		if (firstNameField == null) {
			firstNameField = new JTextField();
			firstNameField.setName("firstNameField");
		}
		return firstNameField;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
