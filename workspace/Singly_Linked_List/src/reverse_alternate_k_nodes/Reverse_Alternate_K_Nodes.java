package reverse_alternate_k_nodes;

import java.util.Scanner;

public class Reverse_Alternate_K_Nodes {
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
		sc.nextLine();
         printLinkedList(head);
         System.out.println("\nEnter the value of k(how much elements you want to reverse in a line)::");
         int k=Integer.parseInt(sc.nextLine());
         head=reverse_alternate_k_Linked_List(head,k);
         System.out.println("Linked List after reversing alternate k elements are::");
         printLinkedList(head);
     }
	public static Node reverse_alternate_k_Linked_List(Node thead,int k)
	{  
		Node prev=null;
		Node current=thead;
		Node next=null;
		int count=0;
		while(current!=null && count < k)
		{
			next=current.getNext();
			current.setNext(prev);
			prev=current;
			current=next;
			count++;
		}
		thead.setNext(current);
		Node backup=prev;
		count=0;
		while(current!=null && count<k)
		{
			prev=current;
			current=current.getNext();
			count++;

			if(count==k-1)
				thead=current;
		}
		prev=backup;
		if(current!=null)
			thead.setNext(reverse_alternate_k_Linked_List(current,k));
		
		return prev;
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
