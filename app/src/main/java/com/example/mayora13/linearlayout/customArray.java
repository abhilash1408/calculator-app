
package com.example.mayora13.linearlayout;

public class customArray {
	public ArrayNode head;
	int size=0;

	public boolean isEmpty(){
		if(this.size==0){
			return true;
		}
		else return false;
	}

	public int size(){
		return this.size;
	}

	public void clear(){
		this.head = null;
		this.size=0;

	}
	public void printList(){
		ArrayNode current = this.head;
		for(int j=0;j<this.size;j++){
			System.out.println(current.content);
			current = current.next;
		}
	}
	public String get(int i){
		ArrayNode current =this.head;
		int j=0;
		while(j<i){
			j++;
			current = current.next;
		}
		return current.content;

	}
	public void remove(int pos ){
		if(pos==0){
			this.head = this.head.next;
			this.size--;
		}
		else{
			int j=0;
			ArrayNode current = this.head;
			current = current.next;
			ArrayNode prev = this.head;
			j++;
			while(j<pos){
				prev = prev.next;
				current = current.next;
				j++;
			}
			prev.next = current.next;
			this.size--;

		}


	}
	public void put(String s,boolean op,int pos ){
		if(pos==0){
			ArrayNode n = new ArrayNode(s,op,null);
			n.next = this.head.next;
			this.head = n;
		}
		else{
			int j=0;
			ArrayNode current = this.head;
			current = current.next;
			ArrayNode prev = this.head;
			j++;
			while(j<pos){
				prev = prev.next;
				current = current.next;
				j++;
			}
			ArrayNode n = new ArrayNode(s,op,null);
			n.next = current.next;
			prev.next = n;

		}


	}

	public void add(String s,boolean op){
		ArrayNode a = new ArrayNode(s,op,null);
		if(size==0){
			this.head = a;
			this.size++;
		}
		else{
			ArrayNode current = head;

			int j=0;
			while(j<size-1){
				j++;
				current = current.next;
			}
			ArrayNode n = new ArrayNode(s,op,null);
			current.next = n;
			this.size++;
		}

	}
	public static void main(String[] args){
		customArray a = new customArray();

		a.add("21", true);
		a.add("25", true);
		a.add("+", false);
		a.add("(",false);
		System.out.println(a.size());
		a.put("55",true,1);
		a.printList();



	}
}
