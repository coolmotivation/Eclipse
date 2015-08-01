package clone_a_linked_list;

import java.util.Scanner;

public class Clone_a_Linked_List {
	 static Node head=new Node();
	 static Node result=new Node();
	 static Node see=new Node();
	  static int n;
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of elements::");
			n=Integer.parseInt(sc.nextLine());
			for(int i=0;i<n;i++)
			{  
				//v.add(sc.nextInt());
				insertion(head,sc.nextInt());
			}
			sc.nextLine();
			System.out.println("Now enter their arbitary pointers::");
			for(int i=0;i<n;i++)
			{
				insert_arbitary(sc.nextInt());
			}
			System.out.println("Original Linked List is::");
			printLinkedList(head);
			System.out.println(" ");
			System.out.println("cloning the linked list by method 1, we get::");
			clone_method1(head);
			printLinkedList(result);
			System.out.println("\ncloning the linked list by method 2, we get::");
			clone_method2(head);
			printLinkedList(head);
			printLinkedList(see);
			
		}
		public static void clone_method2(Node temp)
		{
			while(temp!=null)
			{
				Node newNode=new Node();
				newNode.setData(temp.getData());
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				temp=temp.getNext().getNext();
			}
			temp=head;
			while(temp!=null)
			{   
				Node ntemp=temp.getNext();
				ntemp.setArb(temp.getArb());
				temp=ntemp.getNext();
			}
			temp=head;
			see=head.getNext();
			Node ntemp=temp.getNext();
			while(temp!=null)
			{
				if(temp.getNext().getNext()!=null)
					temp.setNext(temp.getNext().getNext());
				else
					temp.setNext(null);
				if(ntemp.getNext()!=null)
					ntemp.setNext(ntemp.getNext().getNext());
				else
					ntemp.setNext(null);
				temp=temp.getNext();
				ntemp=ntemp.getNext();
			}
		}
		public static void insert_arbitary(int k)
		{
			Node temp=head;
			while(temp.getArb()!=null)
				temp=temp.getNext();
			Node trial=head;
					while(trial.getData()!=k)
					{
						trial=trial.getNext();
					}
					temp.setArb(trial);
		}
		public static void clone_method1(Node temp)
		{
			while(temp!=null)
			{
				insertion(result,temp.getData());
				temp=temp.getNext();
			}
			Node first=head;
			Node second=result;
			while(first!=null)
			{
				second.setArb(first.getArb());
				first=first.getNext();
				second=second.getNext();
			}
			
		}
		public static void insert_result(Node temp)
		{
			if(result.getData() == null)
			{
				result.setData(temp.getData());
				//result.setNext(temp.getNext());
				result.setArb(temp.getArb());
			}
			else
			{   Node t=result;
				while(t.getNext()!=null)
					t=t.getNext();
				Node newNode=new Node();
				t.setNext(newNode);
				newNode.setData(temp.getData());
				//newNode.setNext(temp.getNext());
				newNode.setArb(temp.getArb());
			}
		}
		public static void printLinkedList(Node temp)
		{
			while(temp!=null)
			{
				System.out.printf("%d:",temp.getData());
				if(temp.getArb()!=null)
					System.out.printf("%d\n",(temp.getArb()).getData());
				temp=temp.getNext();
			}
			System.out.println(" ");
		}
		public static void insertion(Node temp,int key)
		{
			if(temp.getData()== null)
			{
				temp.setData(key);
			}
			else
			{
				while(temp.getNext() != null)
					temp=temp.getNext();
				
				Node newNode=new Node();
				newNode.setData(key);
				temp.setNext(newNode);
				
			}
		}
}
