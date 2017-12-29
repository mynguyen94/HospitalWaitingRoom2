/*Name: My Nguyen
 Class: CS 146
 Due Date: 11/19/17
 Date Submitted: 11/19/17
 */
package hashTable;

import patientsInformation.*;

public class HashTables{
	
	private static int tableSize = 11;
	private LinkedList []Table;
	
	//constructor
	public HashTables(){
		Table = new LinkedList[tableSize];
		for(int i = 0; i < tableSize; i++){
			Table[i] = new LinkedList();
		}
	}
		
	//this is hash function, calculate the index where the object need to be inserted in
	public int hashFunction(int priorityCode){
		int index = 0;	
		index = priorityCode % 11;
	
		return index;
	}
	
	//insert a new patient into the hash tables at 
	//a certain index (calculated using hash function)
	public void insertPatient(PatientInfo info){
		int key = info.getNumber();		
		int index = hashFunction(key);	
		Table[index].insertEnd(info);
	}
	
	//search up a patient in the hash table
	public int searchPatient(PatientInfo info){
		int key = info.getNumber();
		int index = hashFunction(key);

		int bucket = Table[index].linearSearch(info); //use linear search to look for the patient

		return bucket;
	}

	//delete a patient  that is found from the hash table
	public void deletePatient(PatientInfo info){
		int key = info.getNumber();
		int index = hashFunction(key); //use hash function to find the index where the patient is at
		
		Table[index].beginIterator(); 
		if(searchPatient(info) == -1){
			System.out.printf("The patient does not exist! \n");
		}
		else{
			for(int i = 1; i < searchPatient(info); i++){
				Table[index].advanceIterator();
			}
			Table[index].deleteIterator();
		}
	}
	
	//find the patient with the most priority in the hash table
	public PatientInfo findLargest(){
		PatientInfo largest = new PatientInfo();
		
		//if the linked list is empty, set the patient object
		//if not set the largest equals to the the patient with most priority at bucket 1 of hash table
		if(Table[0].findHighest() == null){
			largest.setNumber(0);
			largest.setName(" ");
		}
		else
			largest = Table[0].findHighest();
		
		//using for loop, to compare every most priority code at each bucket
		//to find the the most priority of the hash table
		for(int i = 1; i < 11; i++){
			if(Table[i].findHighest() == null){
				;
			}	
			else {
				if(Table[i].findHighest().getNumber() > largest.getNumber()){
					largest = Table[i].findHighest();
				}
			}				
		}	
		return largest;	
	}
	
	//print out all the patients in the hash table
	public void printTable(){
		for(int i = 0; i < tableSize; i++)
		{
			System.out.printf("Bucket: " + i + "  ");
			if(Table[i].getLength() == 0){
				;
			}
			else
			{		
				Table[i].printList();	
			}	
			System.out.printf("\n---------\n");
		}
	}
	
}//end HashTables class
