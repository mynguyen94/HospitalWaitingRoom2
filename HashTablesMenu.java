/*Name: My Nguyen
 Class: CS 146
 Due Date: 11/19/17
 Date Submitted: 11/19/17
 */
package MenuOptions;

import java.util.Scanner;
import hashTable.*;
import patientsInformation.AllPatientsInfo;
import patientsInformation.PatientInfo;
import patientsInformation.ReadFromFile;

public class HashTablesMenu {
	
	public void Menu() {

		Scanner input = new Scanner(System.in);
		String name;
		int number;
		char repeat;
		int index = 21; //index of the array contains the random numbers

		ReadFromFile file = new ReadFromFile();
		file.randomNumber(); // generate a random number for each patient

		AllPatientsInfo info = file.readFile(); // store information of all
												// patients in an array
		HashTables table = new HashTables();

		//insert the first 20 patients
		for(int i = 0;i<20;i++){
			table.insertPatient(info.getPatients(i));
		}

		do
		{
			System.out.printf("Please chose one of the following options\n");
			System.out.printf("-----------------------------------------\n");
			System.out.printf("1. Display the patients in hash table\n");
			System.out.printf("2. Insert a new patient\n");
			System.out.printf("3. Delete a patient\n");
			System.out.printf("4. Search for a patient\n");
		
			System.out.printf("\nYour choice: ");
			int choice = input.nextInt();
			System.out.printf("\n");

			while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
				System.out.printf("Invalid choice. Please enter again(from 1 to 4 only): ");
				choice = input.nextInt();
				System.out.printf("\n");
			}
			
			switch(choice){
			
			//display the list of patients
			case 1:
				System.out.printf("********************\n");
				System.out.printf("* List of patients *\n");
				System.out.printf("********************\n");
				table.printTable();
				break;
			//insert a new patient
			//however, before insertion, display the patient with most priority
			//then delete that patient
			case 2:
				PatientInfo patient1 = new PatientInfo();
				System.out.printf("=> Currently, we are helping patient: ");
				table.findLargest().print();
				table.deletePatient(table.findLargest());
				System.out.printf("\n");
				table.printTable();
				
				System.out.printf("\nINSERTION. Please enter information of the patient: ");
				System.out.printf("\nName: ");
				name = input.next();
				patient1.setName(name);
				patient1.setNumber(file.numArray[index]);
				
				System.out.printf("\n* List of patients *\n");
				table.insertPatient(patient1);
				table.printTable();
				
				index++;
				break;
			//delete a patient
			//first, the current list of patients is display
			//Check the list. Must enter correct name and priority code
			case 3:
				PatientInfo patient = new PatientInfo();
				table.printTable();
				System.out.printf("\nDELETION. Please enter information of the patient: ");
				System.out.printf("\nName: ");
				name = input.next();
				System.out.printf("Number: ");
				number = input.nextInt();
				patient.setNumber(number);
				patient.setName(name);
				
				if(table.searchPatient(patient) == -1){
					System.out.printf("\n=> The patient is not found\n");
				}
				else{
					table.deletePatient(patient);
					System.out.printf("\n* List of patients *\n");
					table.printTable();
				}
				break;
			//search for a patient
			case 4:
				PatientInfo patient3 = new PatientInfo();
				//first, the current list of patients is display
				//Check the list. Must enter correct name and priority code to search.
				table.printTable();
				System.out.printf("\nSEARCH. Please enter information of the patient: ");
				System.out.printf("\nName: ");
				name = input.next();
				System.out.printf("Number: ");
				number = input.nextInt();
				patient3.setName(name);
				patient3.setNumber(number);
				
				if(table.searchPatient(patient3) == -1)
					System.out.printf("\n=> The patient is not found\n\n");
				else
				{
					System.out.printf("\n=> The patient is found at bucket " + table.hashFunction(patient3.getNumber()));
					System.out.printf(" and at index " + table.searchPatient(patient3) + "\n");
				}
				break;		
			}//end switch
			
			System.out.printf("\nDo you want to choose another option? ");
			repeat = input.next().charAt(0);	
			
		} while (repeat == 'y' || repeat == 'Y');
		
		input.close();
		
	}//end Menu class
	
}//end HashTablesMenu class
