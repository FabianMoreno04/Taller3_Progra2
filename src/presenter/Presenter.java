package presenter;

import model.Hospital;
import model.Patient;
import model.Room;
import model.Status;

import view.View;

public class Presenter {
	private Patient patient;
	private Room room;
	private Hospital hospital;
    private View view;
	
    
    
    public Presenter() {
		this.patient = new Patient(null, null, null, null);
		this.room = new Room(0, 0, 0, 0);
		this.hospital = new Hospital();
		this.view = new View();
	}

	public void run() {
        this.menu();
    }

    public void menu() {
        int option = 0;
        while (option != 7) {
            option = showMenu();
            switch (option) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    viewHistoryPatient();
                    break;
                case 4:
                    generateXML();
                    break;    
                case 5:
                    exit();
                    break;
            }
        }
    }

	private int showMenu() {
		int option = view.readInt("-----MENU PRINCIPAL----- "
				+ "\n1. Crear una habitacion"
				+ "\n2. Crear un paciente"
				+ "\n3. Mostrar historial de paciente por habitacion"
				+ "\n4. Generar XML"
				+ "\n7. Salir"
				+ "\nSeleccione una opcion...");
		return option;
	}
	
	private void addRoom() {
		int floorNumber = view.readInt("Numero de piso: ");
		int roomNumber = view.readInt("Numero de habitacion: ");
		int ID = view.readInt("ID de la habitacion: ");
		int bedNumber = view.readInt("Numero de camas de la habitacion: ");
		room = new Room(floorNumber, roomNumber, ID,bedNumber);
		hospital.addRoom(room);
		view.showMessage("!!! Habitacion Creado !!!");
		
	}
	
	private void addPatient() {
		
		String contactPhoneNumber = view.readString("Digite el numero de contacto: ");
		String lastName = view.readString("Nombre del Paciente: ");
		String firstName = view.readString("Apellido del Paciente: ");
		patient = new Patient(contactPhoneNumber, lastName, firstName,Status.ACTIVE);
		room.addPatient(patient);
		view.showMessage("!!! Paciente Creado !!!");
		
	}
	
	private void viewHistoryPatient() {
		// TODO Auto-generated method
		
	}
	
	private void generateXML() {
		hospital.generateXML();
		
	}

	
	

    public void exit() {
        System.exit(0);
    }
    
    
	public static void main(String[] args) {
		Presenter presenter = new Presenter();
		presenter.run();
	}

}
