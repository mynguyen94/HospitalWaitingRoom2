/*Name: My Nguyen
 Class: CS 146
 Due Date: 11/19/17
 Date Submitted: 11/19/17
 */
package binarySearchTree;

import patientsInformation.*;

class BSTNode{
	
	PatientInfo info;
	BSTNode left;
	BSTNode right;
	BSTNode parent;

	//constructor
	public BSTNode(){
		left = null;
		right = null;
		parent = null;
		this.info = new PatientInfo();
	}
	
	//getters
	public BSTNode getLeftNode(){
		return left;
	}
	public BSTNode getRightNode(){
		return right;
	}
	public PatientInfo getInfomration(){
		return info;
	}
	public BSTNode getParent(){
		return parent;
	}

	//setters
	public void setLeftNode(BSTNode node){
		this.left = node;
	}
	public void setRightNode(BSTNode node){
		this.right = node;
	}
	public void setInformation(PatientInfo info){
		this.info = info;
	}
	public void setParent(BSTNode node){
		this.parent = node;
	}
	
}

public class BST {
	
	private BSTNode root;
	
	//constructor
	public BST(){
		root = null;
	}
	//setter
	public void setRoot(BSTNode node){
		this.root = node;
	}
	//getter
	public BSTNode getRoot(){
		return root;
	}
		
	//adding a new value into the BST
	public void BSTInsert(BST Tree, PatientInfo patient){
		BSTNode node = new BSTNode();
		node.info = patient;
		BSTInsert(Tree, node);		
	}
	//this is the pseudo-code from the text book
	public void BSTInsert(BST Tree, BSTNode z){
		BSTNode y = null;
		BSTNode x = Tree.root;
		while(x != null){
			y = x;
			if(z.info.getNumber() < x.info.getNumber()){
				x = x.left;
			}
			else
				x = x.right;
		}
		z.parent = y;
		if(y == null)
			Tree.root = z;
		else if (z.info.getNumber() < y.info.getNumber())
			y.left = z;
		else
			y.right = z;	
		
	}//end BSTInsert
	
	//search for a patient
	public BSTNode BSTSearch(PatientInfo info){	
		
		BSTNode node = root;
		BSTNode correctNode = new BSTNode();
		
		correctNode = BSTSearch(node, info);
		
		//To find the correct node to delete, both name and priority number must match
		//however, sometimes only the number is matching, not the name
		//if-else statement makes sure to return the correct one
		if(correctNode != null){
			if(info.getName().equals(correctNode.info.getName())){
				return correctNode;
			}
			else{
				correctNode = null;
			}
		}	
		return correctNode;			
	}
	//this is the pseudo-code from the text book
	public BSTNode BSTSearch(BSTNode root, PatientInfo patient){
		
		while(root != null && !patient.getName().equals(root.info.getName()) && patient.getNumber() != root.info.getNumber()){
			
			if(patient.getNumber() < root.info.getNumber()){				
					root = root.left;
			}
			else{
					root = root.right;
			}				
		}		
		return root;		
	}
		
	//Delete a patient from the binary search tree
	public void BSTDelete(BST Tree, PatientInfo patient){
		
		BSTNode node = new BSTNode();
		//search to see if the patient is in the tree. If it does, delete it
		node = BSTSearch(root, patient);
		BSTDelete(Tree, node);
		
	}	
	//this is the pseudo-code from the text book
	public void BSTDelete(BST Tree, BSTNode z){
		if(z.left == null){
			Transplant(Tree, z, z.right);		
		}
		else if(z.right == null){
			Transplant(Tree, z, z.left);		
		}
		else{
			BSTNode y = BSTMinimum(z.right);
			
			if(y.parent != z){
				Transplant(Tree, y, y.right);
				y.right = z.right;
				y.right.parent = y;				
			}
			Transplant(Tree, z, y);
			y.left = z.left;
			y.left.parent = y;		
		}	
	}
	
	//move the subtree around within the binary search tree
	//this is the pseudo-code from the text book
	public void Transplant(BST Tree, BSTNode u, BSTNode v){
		if(u.parent == null)
			Tree.root = v;
		else if(u == u.parent.left)
			u.parent.left = v;
		else 
			u.parent.right = v;
		
		if(v != null)
			v.parent = u.parent;	
	}
	
	//print the BST in correct order (ascending order)
	public void inorderPrint(){
		inorderPrint(root);		
	}
	private void inorderPrint(BSTNode node){
		if(node != null){
			inorderPrint(node.left);
			node.info.print();
			inorderPrint(node.right);
		}
	}
	
	//find the maximum value of the BST
	//or this is a patient with most priority
	public PatientInfo BSTMaximum(){
		return BSTMaximum(root);
	}
	public PatientInfo BSTMaximum(BSTNode node){
		while(node.right != null)
			node = node.right;	
		return node.info;	
	}
	
	//find the minimum value of the BST
	//or this is the patient with least priority
	public BSTNode BSTMinimum(){
		return BSTMinimum(root);
	}
	public BSTNode BSTMinimum(BSTNode node){
		while(node.left != null)
			node = node.left;	
		return node;	
	}
		
}//end BST class
