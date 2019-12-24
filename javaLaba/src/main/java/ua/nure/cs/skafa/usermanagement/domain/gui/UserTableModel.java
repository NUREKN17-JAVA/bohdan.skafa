package ua.nure.cs.skafa.usermanagement.domain.gui;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ua.nure.cs.skafa.usermanagement.domain.User;

public class UserTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 8600165500511058436L;
	private static final String[] COLUMN_NAMES = {"ID", "Name", "LastName"};
	private static final Class[] COLUMN_CLASSES = {Long.class, String.class, String.class};
	private List users = null;
	
	public UserTableModel(Collection<User> users) {
		this.users = new ArrayList(users);
	}
	
	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}
	@Override
	public int getRowCount() {
		return users.size();
	}
	
    public User getUser(int index) {
        return (User) users.get(index);
    }
	
	@Override
	public Class getColumnClass(int columnIndex) {
		return COLUMN_CLASSES[columnIndex];
	}

	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = (User) users.get(rowIndex);
		switch(columnIndex) { 
		case 0:
			return user.getId();
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName();
		}
		return null;
	}

	public void addUsers(Collection users2) {
		// TODO Auto-generated method stub
		
	}

	public void clearUsers() {
		// TODO Auto-generated method stub
		
	}

}
