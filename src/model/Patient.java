package model;

public class Patient {
	private String contactPhoneNumber;
	private String firstName;
	private String lastName;
	private Status status;
	
	
	public Patient(String contactPhoneNumber, String firstName, String lastName, Status status) {
		this.contactPhoneNumber = contactPhoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
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
	public Status getStatus() {
	        return status;
	}

	public void setStatus(Status status) {
	        this.status = status;
	}
	@Override
	public String toString() {
		return contactPhoneNumber + ", " + firstName + ", "
				+ lastName + ", " + status ;
	}
	
	
}
