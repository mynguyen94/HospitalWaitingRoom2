# HospitalWaitingRoom2
package MenuOptions;

import java.util.Scanner;

import binarySearchTree.BST;
import patientsInformation.AllPatientsInfo;
import patientsInformation.PatientInfo;
import patientsInformation.ReadFromFile;

public class BSTMenu {

	public void Menu() {

		Scanner input = new Scanner(System.in);
		char repeat; //stores the user answer if they want to continue a certain choice
		String name; //holds the patient's name
		int number; //holds the patient's number
		int index = 21; //index of the array contains the random numbers

		ReadFromFile file = new ReadFromFile(); 
		file.randomNumber(); // generate a random number for each patient

		AllPatientsInfo info = file.readFile(); //store information of all patients in an array
		BST bst = new BST();  //create an object of binary search tree

		// insert the first 20 patients into the binary search tree
		for (int i = 0; i < 20; i++) {
			bst.BSTInsert(bst, info.getPatients(i));
		}
		
		// the user must choose one of the option from the menu
		do {
			System.out.printf("Please chose one of the following options\n");
			System.out.printf("-----------------------------------------\n");
			System.out.printf("1. See the curent list of patients\n");
			System.out.printf("2. Insert a new patient\n");
			System.out.printf("3. Delete a patient\n");

			System.out.printf("\nYour choice: ");
			int choice = input.nextInt();
			System.out.printf("\n");

			while (choice != 1 && choice != 2 && choice != 3) {
				System.out.printf("Invalid choice. Please enter again(from 1 to 3 only): ");
				choice = input.nextInt();
				System.out.printf("\n");
			}

			// perform different function based on the user's choice
			switch (choice) {

			case 1:
				// print out the BST in order
				System.out.printf("--------------------\n");
				System.out.printf("* List of patients *\n");
				System.out.printf("--------------------\n");
				bst.inorderPrint();
				break;	
			case 2:
				//print out the patient with most priority and then delete that person
				System.out.printf("=> " + "Currently, we are helping patient: ");
				bst.BSTMaximum().print();
				System.out.printf("\n");
				bst.BSTDelete(bst, bst.BSTMaximum());
						
				// insert a new patient
				// only need to enter the name
				// the priority number is set from the array contains random
				// numbers
				PatientInfo patient = new PatientInfo(); // create an object of
															// a patient
				System.out.printf("Please enter infomration of the patient\n");
				System.out.printf("Name: ");
				name = input.next();
				patient.setName(name);
				patient.setNumber(file.numArray[index]);

				bst.BSTInsert(bst, patient);

				System.out.printf("--------------------\n");
				System.out.printf("* List of patients *\n");
				System.out.printf("--------------------\n");
				bst.inorderPrint();

				index++;
				break;
			case 3:
				PatientInfo patient1 = new PatientInfo(); // create an object of
															// a patient
				System.out.printf("Please enter infomration of the patient\n");
				System.out.printf("Name: ");
				name = input.next();
				System.out.printf("Number: ");
				number = input.nextInt();
				patient1.setName(name);
				patient1.setNumber(number);

				if (bst.BSTSearch(patient1) == null) {
					System.out.printf("\nThe patient does not exist \n");
				} else {
					bst.BSTDelete(bst, patient1);
					System.out.printf("\nThe patient has been removed: ");
					patient1.print();
					System.out.printf("--------------------\n");
					System.out.printf("* List of patients *\n");
					System.out.printf("--------------------\n");
					bst.inorderPrint();
				}

			}// end switch

			System.out.printf("\nDo you want to choose another option? ");
			repeat = input.next().charAt(0);

		} while (repeat == 'y' || repeat == 'Y');
		
		input.close();
	}//end Menu

}//end BSTMenu class
