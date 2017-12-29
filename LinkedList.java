/*Name: My Nguyen
 Class: CS 146
 Due Date: 11/19/17
 Date Submitted: 11/19/17
 */
package hashTable;

import patientsInformation.PatientInfo;

class Node {

	PatientInfo info;
	Node nextnode;
	Node previousnode;

	// constructor
	public Node(PatientInfo patient) {
		this.info = patient;
		nextnode = null;
		previousnode = null;
	}
		
	// getters
	public PatientInfo getInformation() {
		return info;
	}
	public Node getNextnode() {
		return nextnode;
	}
	public Node getPreviousnode() {
		return previousnode;
	}
	
	// setters
	public void setInformation(PatientInfo info) {
		this.info = info;
	}
	public void setNextnode(Node node) {
		this.nextnode = node;
	}
	public void setPreiousnode(Node node) {
		this.previousnode = node;
	}
	
}//end Node class
	
public class LinkedList{
		
	private int length;
	private Node begin;
	private Node end;
	private Node iterator;
		
	//constructor
	public LinkedList() {
		length = 0;
		begin = null;
		end = null;
		iterator = null;
	}
	//getter
	public int getLength() {
		return length;
	}
		
		//setter
	public void setLength(int size) {
		this.length = size;
	}
		
	public void beginIterator() {
		iterator = begin;
	}
	
	public void advanceIterator() {
		assert (iterator != null);
		iterator = iterator.nextnode;
	}		
	
	//this function allow insert a new patient in the double linked list
	public void insertEnd(PatientInfo patient) {
		Node N = new Node(patient);
		if (length == 0) {
			end = begin = N;
		} else {
			end.nextnode = N;
			N.previousnode = end;
			end = N;
		}
		length++;
	}

	//this function delete the first patient in the linked list
	public void deleteBegin() {
		assert (length != 0);
		if (length == 1) {
			begin.info = null;
			begin = end = null;
			length = 0;

		} else {
			Node temp = begin; // store this location so we don't lose
									// access to it
			begin = begin.nextnode; // advance the pointer
			temp.info = null; // free the memory for the original begin node
			begin.previousnode = null;
			length--;
		}
	}

	//this function delete the last patient in the linked list
	public void deleteEnd() {
		assert (length != 0);
		if (length == 1) {
			end.info = null;
			end = begin = null;
			length = 0;

			// fill in the missing lines here

		} else {
			Node temp = begin;
			while (temp.nextnode != end) {
				temp = temp.nextnode; // advance the pointer to find 2nd to last
										// node
			}
			end.info = null; //free the memory for the original last node
			end = temp; // set the new end node
			end.nextnode = null; // so last->next is not pointing at freed
										// memory
			length--;
		}
	}

	//this function delete the patient where the iterator is pointing at
	public void deleteIterator() {
		assert (length != 0 && iterator != null);
		if (iterator == begin) {
			deleteBegin();

		} else if (iterator == end) {
			deleteEnd();

		} else {
			iterator.previousnode.nextnode = iterator.nextnode;
			iterator.nextnode.previousnode = iterator.previousnode;
			iterator.info = null;
			length--;
		}
		iterator = null;
	}
	
	//search for the patient using linear search
	public int linearSearch(PatientInfo info) {
		assert (length != 0);
		int index = 1;
		int position = -1;
		boolean found = false;

		Node temp = begin;
		while (index <= length && !found) {
			if (temp.info.getNumber() == info.getNumber() && temp.info.getName().equals(info.getName())) {
				found = true;
				position = index;
			}
			index++;
			temp = temp.nextnode;
		}
		return position;
	}
	
	//return the patient where the iterator is pointing at
	public PatientInfo getIterator(){
		assert(iterator != null);
		return iterator.info;
	}
	
	//get the first patient in the double linked list
	public PatientInfo getBegin(){
		assert(length == 0);
	    return begin.info;
	}
	
	//find the patient with most priority in the double linked list
	public PatientInfo findHighest(){
		PatientInfo highest = new PatientInfo();
		
		if(getLength() == 0)
			highest = null;
		else{
			highest = getBegin();
			beginIterator();
			for(int i  = 0; i < getLength(); i++){
				if(getIterator().getNumber() > highest.getNumber()){
					highest = getIterator();
				}
				advanceIterator();
			}		
		}	
		return highest;
	}

	//print out patient of one linked list
	public void printList() {
		Node iter = begin;
		while (iter != null) {
			System.out.printf(iter.info.getName() + " " + iter.info.getNumber() + "   ");
			iter = iter.nextnode;
		}
	}
}

