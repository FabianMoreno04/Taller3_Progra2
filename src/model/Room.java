package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private int floorNumber;
	private int roomNumber;
	private int id;
	private int bedNumbers;
	private Patient[] patients;
	private int countBed;
	
	public Room(int floorNumber, int roomNumber, int id, int bedNumbers) {
		this.floorNumber = floorNumber;
		this.roomNumber = roomNumber;
		this.id = id;
		this.bedNumbers = bedNumbers;
		this.patients = new Patient[bedNumbers];
        countBed = 0;
	}
	
	 public boolean empyBeds() {
	        for (int i = 0; i < 10; i++) {
	            if (patients[i].getStatus() == Status.ACTIVE) {
	                countBed = i;
	                return true;
	            }
	        }
	        return false;
	    }
	public void addPatient (Patient patient) {
		patients[countBed] = patient;
        countBed++;
		
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBedNumbers() {
		return bedNumbers;
	}
	public void setBedNumbers(int bedNumbers) {
		this.bedNumbers = bedNumbers;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	@Override
	public String toString() {
		return floorNumber + ", " + roomNumber + ", " + id + ", "
				+ bedNumbers;
	}

	
	
}
