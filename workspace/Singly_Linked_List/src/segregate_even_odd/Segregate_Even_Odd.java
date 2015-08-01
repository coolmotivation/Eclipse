package segregate_even_odd;

import java.util.Scanner;

import delet_nodes_with_greater_value_on_right.Node;

public class Segregate_Even_Odd {
	static Node head=new Node();
	static int n;
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements::");
		 n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			insertion(sc.nextInt());
		}
		sc.nextLine();
         printLinkedList(head);
         
         System.out.println("\nSegregating even and odd elements from the linked list, we get::");
         segregate_even_odd();
         printLinkedList(head);
     }
	public static void segregate_even_odd()
	{   int count=0;
	   
		Node end=head;
		while(end.getNext()!=null)
		{
			end=end.getNext();
		}///now end is the last node where odd elements are to be appended
		
		
		while(head.getData()%2 !=0 && count < n)  // head is odd then append it to end
		{
			end.setNext(head);
			head=head.getNext();
			end = end.getNext();
			end.setNext(null);
			count++;
			//System.out.println("hxdi");
		}
		
		
		Node temp=head;//head is even element
		count++;
		while(count < n)
		{
			Node t=temp.getNext();      // temp->t->nt
			Node nt=t.getNext();
			if(t.getData()%2 != 0)
			{
				temp.setNext(nt);
				end.setNext(t);
				end=t;
				t.setNext(null);
			}
			else
				temp=temp.getNext();
			
			count++;
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
