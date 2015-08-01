package swap_k_nodes;

import java.util.Scanner;

public class Swap_k_Nodes {
  static Node head=new Node();
  static int n;
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements::");
		n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{  
			//v.add(sc.nextInt());
			insertion(sc.nextInt());
		}
		sc.nextLine();
		System.out.println("enter the element to be swapped::");
		int k=Integer.parseInt(sc.nextLine());
		swap(k);
		printLinkedList();
	}
	public static void swap(int k)
	{
		Node temp=head;
		Node ptemp=null;
		int cn=1;
		while(cn!=k)
		{
			ptemp=temp;
			temp=temp.getNext();
		    cn++;
		}
		Node pfirst=ptemp;
		Node first=temp;
		Node nfirst=first.getNext();
		
		Node psecond=head;
		cn=1;
		while(cn!=n-k)
		{
			psecond=psecond.getNext();
			cn++;
		}
		Node second=psecond.getNext();
		Node nsecond=second.getNext();
		
		if(second.getNext()==first)
		{
			psecond.setNext(first);
			first.setNext(second);
			second.setNext(nfirst);
		}
		else if(first.getNext()==second)
		{
			pfirst.setNext(second);
			second.setNext(first);
			first.setNext(nsecond);
		}
		else if(first.getData() == second.getData())
			return;
		else
		{
			if(pfirst!=null)
				pfirst.setNext(second);
			second.setNext(nfirst);
			if(pfirst==null)
				head=second;
			
			psecond.setNext(first);
			first.setNext(nsecond);
		}
	}
	public static void printLinkedList()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.printf("%d ",temp.getData());
			temp=temp.getNext();
		}
		System.out.println(" ");
	}
	public static void insertion(int key)
	{
		if(head.getData()== null)
		{
			head.setData(key);
		}
		else
		{
			Node temp=head;
			while(temp.getNext() != null)
				temp=temp.getNext();
			
			Node newNode=new Node();
			newNode.setData(key);
			temp.setNext(newNode);
			
		}
	}
}
