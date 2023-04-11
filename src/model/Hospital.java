package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Hospital {
	private List<Room> rooms;

	public Hospital() {
		this.rooms = new ArrayList<Room>();
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	public void leerXML() {
		try {
			File archivo = new File("rooms.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			
			document.getDocumentElement().normalize();
			
			System.out.println("Elemento Raiz" + document.getDocumentElement().getNodeName());
			
			NodeList listrooms = document.getElementsByTagName("room");
			for (int i = 0; i < listrooms.getLength(); i++) {
				Node nodo = listrooms.item(i);
				System.out.println("Elemento: " + nodo.getNodeName());
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					System.out.println("floorNum: " + element.getElementsByTagName("floorNum").item(0).getTextContent());
					System.out.println("roomNumber: " + element.getElementsByTagName("roomNumber").item(0).getTextContent());
					System.out.println("patient: " + element.getElementsByTagName("patient").item(0).getTextContent());
					System.out.println("firstName: " + element.getElementsByTagName("firstName").item(0).getTextContent());
					System.out.println("lastName: " + element.getElementsByTagName("lastName").item(0).getTextContent());
					System.out.println("contactPhoneNumber: " + element.getElementsByTagName("contactPhoneNumber").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void generateXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation dom = builder.getDOMImplementation();
			
			Document document =  dom.createDocument(null, "hospital", null);
			document.setXmlVersion("1,0");
			
			for (int i = 0; i < rooms.size(); i++) {
				Element numrooms = document.createElement("rooms");
				
				Element room = document.createElement("room");
				room.setAttribute("id", "1");
				
				Element floorNum = document.createElement("floorNumber");
				Text floorNumber = document.createTextNode(""+ rooms.get(i).getFloorNumber());
				floorNum.appendChild(floorNumber);
				
				Element roomNum = document.createElement("roomNumber");
				Text roomNumber = document.createTextNode(""+ rooms.get(i).getRoomNumber());
				roomNum.appendChild(roomNumber);
				
				Element patient = document.createElement("patient");
				room.appendChild(patient);
				
				Element firstName= document.createElement("firstName");
				Text NameOne = document.createTextNode(""+ rooms.get(i).getPatients().get(i).getFirstName());
				firstName.appendChild(NameOne);
				
				Element lastName= document.createElement("lastName");
				Text NameTwo = document.createTextNode(""+ rooms.get(i).getPatients().get(i).getLastName());
				lastName.appendChild(NameTwo);
				
				Element contactPhoneNumber= document.createElement("contactPhoneNumber");
				Text contactPhone = document.createTextNode(""+ rooms.get(i).getPatients().get(i).getContactPhoneNumber());
				contactPhoneNumber.appendChild(contactPhone);
				
				patient.appendChild(firstName);
				patient.appendChild(lastName);
				patient.appendChild(contactPhoneNumber);
				room.appendChild(floorNum);
				room.appendChild(roomNum);
				room.appendChild(patient);
				numrooms.appendChild(room);
				
				document.getDocumentElement().appendChild(numrooms);
				
				Source source = new DOMSource(document);
				Result result = new StreamResult(new File("rooms.xml"));
				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source, result);
				
				System.out.println("Archivo XML creado exitosamente");
			}
			
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}
}
