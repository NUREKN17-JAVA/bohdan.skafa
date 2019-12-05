package ua.nure.cs.skafa.usermanagement.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = -4969464985132574536L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirthd;
	
	public User(String firstName, String lastName, Date date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirthd = date;
	}
	public User(Long id, String firstName, String lastName, Date date) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirthd = date;
	}
	public User() {
		
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getId() == null && ((User) obj).getId() == null) {
			return true;
		}
		return this.getId().equals(((User) obj).getId());
	}
	@Override
	public int hashCode() {
		if (this.getId() == null) {
			return 0;
		}
		return this.getId().hashCode();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirthd;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirthd = dateOfBirth;
	}
	public String getFullName() {
		return getLastName() + " " + getFirstName();
	}
	public int getAge() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currenrYear = calendar.get(Calendar.YEAR);
		calendar.setTime(getDateOfBirth());
		int birthYear = calendar.get(Calendar.YEAR);
		return currenrYear - birthYear;
	}
}
