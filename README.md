# HospitalWaitingRoom2

- This program is written to help a hospital emergency room keep track of the patient lists in order for appropriate assistance. The hospital emergency room prioritizes patients waiting based on the severity of their need. The doctors in would see the next most critical patient rather than the one who arrived first. Larger integers are considered higher priority than smaller ones	
- The program is written with two different approaches: Binary Search Tree (BST) and Hash Tables. 
	1. BST
	   => Build a patient BST
    	   => Insert a patient to the BST based on the priority code. 
    	   => Delete a patient from the BST. 
   	   => Make a sorted list of patients according to the priority codes. 
	2. Hash Tables: avoiding collision by using Chaining method
	   => Create a 11-slots separate chaining Hash Table for the 20 patients. 
	   => Insert a patient to the Hash Table. 
	   => Search a patient's name by entering a priority code. 
	   => Delete a patient from the Hash Table. 
	   => Make a list of patients of the hash table. 
- The hospital emergency room waiting list always contains 20 patients. Each patient will be randomly assigned a distinct priority code. 
- Especially, the program must be dynamically and efficiently written in Java language. 
