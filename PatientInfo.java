/*Name: My Nguyen
 Class: CS 146
 Due Date: 11/19/17
 Date Submitted: 11/19/17
 */
package patientsInformation;

//this is a class consists information of each patient:
//name and priority code
public class PatientInfo {

	private String patientName;
	private int orderNumber;
	
	//constructor
	public PatientInfo (){
		patientName = " ";
		orderNumber = 0;
	}
	
	//getter
	public String getName(){
		return patientName;
	}
	public int getNumber(){
		return orderNumber;
	}
	
	//setter
	public void setName(String name){
		this.patientName = name;
	}
	public void setNumber(int number){
		this.orderNumber = number;
	}
	
	//display information for each patient
	public void print(){
	
			System.out.printf(getName() + "  " + getNumber());
			System.out.printf("\n");
	}
	
}//end PatinetInfo
