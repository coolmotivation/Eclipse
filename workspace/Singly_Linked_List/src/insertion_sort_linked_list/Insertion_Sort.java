package insertion_sort_linked_list;

import java.util.Scanner;

import linked_list.Node;

public class Insertion_Sort {
	static Node head=new Node();
	static int count=0;
	
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
			System.out.println("Elements in the sorted order is::");
			printLinkedList();
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
				Node ptemp=null;
				while(temp!= null)
					{
					  if(key > temp.getData())
						  	{
						     ptemp=temp;
						     temp=temp.getNext();
						  	}
					  else
						  break;
					}
				
				Node newNode=new Node();
				newNode.setData(key);
				if(ptemp!=null)
					ptemp.setNext(newNode);
				else
					head=newNode;
				newNode.setNext(temp);
				
			}
		}
}
