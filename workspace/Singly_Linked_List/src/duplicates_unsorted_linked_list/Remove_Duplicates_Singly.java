package duplicates_unsorted_linked_list;

import java.util.Scanner;

public class Remove_Duplicates_Singly {
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
             printLinkedList();
             System.out.println("\n removing duplicates from the linked list ::\n");
             remove_duplicate_method1();
             printLinkedList();
		}
		public static void remove_duplicate_method1()
		{
			Node temp=head;
			while(temp.getNext()!=null)
			{
				Node ntemp=temp.getNext();
				Node dummy=temp;
				while(ntemp!=null)
				{   
					if(ntemp.getData() == temp.getData())
					{
					     dummy.setNext(ntemp.getNext());	
					}
					else
						dummy=ntemp;
					ntemp=ntemp.getNext();
				}
				temp=temp.getNext();
				if(temp==null)
					break;
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