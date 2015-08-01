package singly_linked_list_plaindrome;

import java.util.*;
import java.io.*;
import java.util.Stack;
public class Check_Palindrome {
	static Node head=new Node();
	static Node dhead=new Node();
	static Stack s=new Stack();
		public static void main(String args[]) throws IOException
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			insertion('r');
			insertion('a');
			insertion('d');
			insertion('a');
			insertion('r');
			
		method1_reverse_list();
		method2_stack();
			
		}
		public static void method2_stack()
		{
			Node temp=head;
			while(temp!=null)
			{
				s.push(temp.getData());
				temp=temp.getNext();
			}
			temp=head;
			while(temp!=null)
			{
				if(temp.getData()==s.pop())
					temp=temp.getNext();
				else
					break;
			}
			if(temp==null)
				System.out.println("String is palindrome!!!");
			else
				System.out.println("String is not palindrome!!!");
		}
		public static void method1_reverse_list()
		{
			create_duplicate();
			Node temp=head;
			Node dtemp=dhead;
			while(temp!=null && dtemp!=null)
			{
				if(temp.getData() == dtemp.getData())
				{
					temp=temp.getNext();
					dtemp=dtemp.getNext();
				}
				else
					break;
			}
			if(temp==null && dtemp==null)
				System.out.println("String is palindrome!!!");
			else
				System.out.println("String is not palindrome!!!");
		}
		public static void insertion(char key)
		{
			if(head.getData()==null)
				head.setData(key);
			else
			{
				Node temp=head;
				while(temp.getNext()!=null)
					temp=temp.getNext();
				Node newNode=new Node();
				newNode.setData(key);
				temp.setNext(newNode);
			}
		}
		public static void create_duplicate()
		{
			 if(dhead.getData()==null)
				 dhead.setData(head.getData());
			 
			   Node temp=head;
			    while(temp.getNext()!=null)
                 {  
			    	Node newNode=new Node();
			    	temp=temp.getNext();
			    	 newNode.setData(temp.getData());
			    	 newNode.setNext(dhead);
			    	 dhead=newNode;
			    	 
                 }
				
			 
		}
			
}
