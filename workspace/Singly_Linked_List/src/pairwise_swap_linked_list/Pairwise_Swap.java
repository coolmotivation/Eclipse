package pairwise_swap_linked_list;

import java.util.Scanner;

public class Pairwise_Swap {
	static Node head=new Node();
	static Node nhead=new Node();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements::");
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			insertion(sc.nextInt());
		}
         printLinkedList(head);
        System.out.println("\n Linked list after pairwise swapping is::");
        pairwise_swap_iteratively();
        printLinkedList(head);
        System.out.println("\n Linked List after pairwise swapping recursively is::");
        pairwise_swap_recursively(head);
        printLinkedList(head);
        /*System.out.println("\n Linked List after deleting alternate elements iteratively is::");
        delete_alternate_iteratively();
        printLinkedList();*/
        System.out.println("\n Linked List after appending alternate elements into another linked list is::");
        split_alternate_iteratively(head);
        System.out.println("First LinkedList is::");
        printLinkedList(head);
        System.out.println("\nSecond LinkedList is::");
        printLinkedList(nhead);
	}
	public static void delete_alternate_recursively(Node temp)
	{
		if(temp==null || temp.getNext()==null)
			return;
		else
		{
			temp.setNext((temp.getNext()).getNext());
			delete_alternate_recursively(temp.getNext());
		}
	}
	public static void split_alternate_iteratively(Node temp)
	{
		Node ntemp=head.getNext();
		while(ntemp!=null)
		{
			if(nhead.getData()==null)
			{
				nhead.setData(ntemp.getData());
			}
			else
			{
				Node f=nhead;
				while(f.getNext()!=null)
					f=f.getNext();
				Node newNode =new Node();
				newNode.setData(ntemp.getData());
				f.setNext(newNode);
			}
			temp.setNext(ntemp.getNext());
			temp=temp.getNext();
			if(temp==null)
				break;
			ntemp=temp.getNext();
			if(ntemp==null)
				break;
		}
	}
	public static void pairwise_swap_recursively(Node t)
	{
		if(t==null)
			return;
		Node temp=t.getNext();
		if(temp==null)
			return;
		else
		{
			int key=temp.getData();
			temp.setData(t.getData());
			t.setData(key);
			pairwise_swap_recursively(temp.getNext());
		}
		
	}
	public static void pairwise_swap_iteratively()
	{
		if(head.getNext()==null)
		{
			return;
		}
		else
		{
		Node temp=head;
		Node ntemp=temp.getNext();
		while(ntemp!=null)
		{
			int key=temp.getData();
			temp.setData(ntemp.getData());
			ntemp.setData(key);
			temp=ntemp.getNext();
			if(temp==null)
				break;
			ntemp=temp.getNext();
			if(ntemp==null)
				break;
		}
		}
	}
	
	public static void printLinkedList(Node temp)
	{
		while(temp!=null)
		{
			System.out.printf("%d ",temp.getData());
			temp=temp.getNext();
		}
	}
	public static void insertion(int key)
	{
		if(head.getData()==null)
			head.setData(key);
		else
		{
			Node temp=head;
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

