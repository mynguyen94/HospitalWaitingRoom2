/*Name: My Nguyen
 Class: CS 146
 Due Date: 11/19/17
 Date Submitted: 11/19/17
 */
package patientsInformation;

public class AllPatientsInfo {
	
	public PatientInfo patients[] = new PatientInfo[20]; //an array of patients
	
	//getter
	public PatientInfo getPatients(int i){
		return patients[i];
	}
	
	//setter
	public void setPatients(PatientInfo info, int i){
		this.patients[i] = info;
	}
	
}
