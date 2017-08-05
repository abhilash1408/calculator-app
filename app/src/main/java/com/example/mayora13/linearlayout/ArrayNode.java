package com.example.mayora13.linearlayout;

public class ArrayNode {
	public boolean number = false;
	public String content;
	public ArrayNode next;
	
	public  ArrayNode(String s,boolean num,ArrayNode nxt){
		content =s;
		number = num;
		next = nxt;
	}

}
