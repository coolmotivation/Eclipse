package reverse_linked_list;

import java.util.Scanner;

import pairwise_swap_linked_list.Node;

public class Reverse_Linked_List {
	static Node head=new Node();
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
         System.out.println(" ");
         reverse_Linked_List_iteratively();
         System.out.println("Linked List after reversing is::");
         printLinkedList(head);
         System.out.println("\nLinked List after reversing recursively is::");
         reverse_Linked_List_recursively(null,head);
         printLinkedList(head);
	}
	public static void reverse_Linked_List_iteratively()
	{
		Node prev=null;
		Node current=head;
		Node next=null;
		while(current!=null)
		{
			next=current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
		}
		head=prev;
	}
	public static void reverse_Linked_List_recursively(Node prev,Node current)
	{
		if(current == null)
		{
			head=prev;
			return;
		}
		else
		{
			prev=current;
			current=current.getNext();
			reverse_Linked_List_recursively(prev,current);
			if(current==null)
				return;
			current.setNext(prev);
			prev.setNext(null);
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
