package insertion_in_sorted_cll;


import java.util.Scanner;

public class Insertion_In_CLL {
	static Node head=new Node();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the numner of elements::");
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			insertion(sc.nextInt());
		}
		sc.nextLine();
		System.out.println("the Singly Circular linked list in sorted order entered till now is::");
		printLinkedList();
	}
	
	public static void insert_beginning(int key)
	{
		Node newNode=new Node();
		  newNode.setData(key);
		  if(head.getData()==null)
			  {
			  head=newNode;
			  head.setNext(head);
			  return;
			  }
		  Node temp=head;
		  while(temp.getNext()!=head)
			  temp=temp.getNext();
		  temp.setNext(newNode);
		  newNode.setNext(head);
		  head=newNode;
	}
	public static void insert_end(int key)
	{
		Node newNode=new Node();
		newNode.setData(key);
		Node temp=head;
		while(temp.getNext()!=head)
			temp=temp.getNext();
		temp.setNext(newNode);
		newNode.setNext(head);
	}
	public static void printLinkedList()
	{
		Node temp=head;
		if(head==null)
		{
		System.out.println("null");
		return;
		}
		if(head.getData()!=null)
			System.out.printf("%d ",temp.getData());
		
		
		temp=temp.getNext();
		while(temp!=head)
		{   
			System.out.printf("%d ",temp.getData());
			temp=temp.getNext();
		}
		
	}
	public static void insertion(int key)
	{
		 if(head.getData()==null)   //case 1:LinkedList is empty
		{  
			head.setData(key);
			head.setNext(head);
		}
		else
		{
			Node newNode=new Node();
			newNode.setData(key);
			
			Node temp=head;        // case 2:Node to be inserted is before the head
			if(head.getData() > key)
				{
				insert_beginning(key);
				return;
				}
			
			temp=head;
			while(temp.getNext().getData() < key)
			{
				temp=temp.getNext();
				if(temp==head)            // case 3:Node to be inserted is after the last element
				{
					insert_end(key);
					return;
				}
			}
			Node ntemp=temp.getNext();  //case 4:Node to be inserted is somewhere after head
			temp.setNext(newNode);
			newNode.setNext(ntemp);
		}
	}
}
