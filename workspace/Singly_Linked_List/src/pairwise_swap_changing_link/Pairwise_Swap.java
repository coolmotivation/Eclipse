package pairwise_swap_changing_link;

import java.util.Scanner;

public class Pairwise_Swap {
	static Node head=new Node();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements in the linked list::");
		int y=Integer.parseInt(sc.nextLine());
		for(int i=0;i<y;i++)
		{
			insertion(head,sc.nextInt());
		}
		sc.nextLine();
		pairwise_swap_by_changing_link(null,head);
		System.out.println("Pairwise swapping by changing the links we get::");
		printLinkedList(head);
	}
	public static void pairwise_swap_by_changing_link(Node prev,Node temp)
	{       
		if(temp==null)
			return;
		if(temp!=null && temp.getNext()==null)//if there are odd numbers of elements
			{
			if(prev!=null)
			prev.setNext(temp);
			return;
			}
		    Node ntemp=temp.getNext();
			Node nntemp=ntemp.getNext();
			ntemp.setNext(temp);
		    if(prev!=null)
		    	prev.setNext(ntemp);
		    else
		    	head=ntemp;
		    temp.setNext(null);
		    pairwise_swap_by_changing_link(temp,nntemp);
	}
	public static void printLinkedList(Node temp)
	{
		while(temp!=null)
		{
			System.out.printf("%d ",temp.getData());
			temp=temp.getNext();
		}
	}
	public static void insertion(Node temp,int key)
	{   
		if(temp.getData()==null)
			{
			temp.setData(key);
			//System.out.println(temp.getData());
			}
		else
		{
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			Node newNode=new Node();
			newNode.setData(key);
			temp.setNext(newNode);
			
		}
	}
	
}
