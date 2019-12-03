package ua.nure.cs.skafa.usermanagement.domain.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BrowsePanel extends JPanel implements ActionListener {

	private MainFrame parent;
	private JPanel buttonPanel;
	private JButton addButton;
	private JButton detailsButton;
	private JButton deleteButton;
	private JButton editButton;
	private JScrollPane tablePanel;
	private JTable userTable;

	public BrowsePanel(MainFrame frame) {
		parent = frame;
		initialize(); 
	}

	private void initialize() {
		this.setName("browsePanel");
		this.setLayout(new BorderLayout());
		this.add(getTablePanel(), BorderLayout.CENTER);
		this.add(getButtonPanel(), BorderLayout.SOUTH);
		
	}

	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getAddButton(), null);
			buttonPanel.add(getEditButton(), null);
			buttonPanel.add(getDeleteutton(), null);
			buttonPanel.add(getDetailsButton(), null);
		}
		return buttonPanel;
	}
	
	private JScrollPane getTablePanel() {
		if (tablePanel == null) {
			tablePanel = new JScrollPane(getUserTable());
		}
		return tablePanel;
	}

	private JTable getUserTable() {
		if (userTable == null) {
			userTable = new JTable();
			userTable.setName("userTable");
		}
		return userTable;
	}

	private JButton getDetailsButton() {
		if (detailsButton == null) {
			detailsButton = new JButton();
			detailsButton.setText("Детали");
			detailsButton.setName("detailsButton");
			detailsButton.addActionListener(this);
		}
		return detailsButton;
	}

	private JButton getDeleteutton() {
		if (deleteButton == null) {
			deleteButton = new JButton();
			deleteButton.setText("Удалить");
			deleteButton.setName("deleteButton");
			deleteButton.addActionListener(this);
		}
		return deleteButton;
	}

	private JButton getEditButton() {
		if (editButton == null) {
			editButton = new JButton();
			editButton.setText("Изменить");
			editButton.setName("editButton");
			editButton.addActionListener(this);
		}
		return editButton;
	}

	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setText("Добавить");
			addButton.setName("addButton");
			addButton.addActionListener(this);
		}
		return addButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if ("add".equalsIgnoreCase(actionCommand)) { 
			this.setVisible(false);
			parent.showAddPanel();
		}
		
	}



}
