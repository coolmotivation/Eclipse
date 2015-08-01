package sorted_linked_list;
import java.util.Scanner;

public class Sorted_Linked_List {
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
			 printSortedLinkedList();
			System.out.println("\nLinked list in reverse order using recursive approach::");
			recursive_reverse_order(head);
			System.out.println("Linked List after removing duplicates from the sorted Linked List::");
			remove_duplicate();
			printSortedLinkedList();
		}
		public static void printSortedLinkedList()
		{
			Node temp=head;
			while(temp!=null)
			{
				System.out.printf("%d ",temp.getData());
				temp=temp.getNext();
			}
		}
		public static void remove_duplicate()
		{
			Node temp=head;
			Node ntemp=head.getNext();
			while(ntemp != null)
			{
			     while(temp.getData() == ntemp.getData())
			     {
			    	 temp.setNext(ntemp.getNext());
			    	 ntemp=ntemp.getNext();
			    	 if(ntemp==null)
			    		 break;
			     }
			     if(ntemp == null)
			    	 break;
			     temp=ntemp;
			     ntemp=ntemp.getNext();
			}
		}
		public static void recursive_reverse_order(Node temp)
		{
			if(temp==null)
				return;
			else
			{
				recursive_reverse_order(temp.getNext());
				System.out.printf("%d ",temp.getData());
				
			}
		}
		public static void insertion(int key)
		{
			if(head.getData()==null)
			{
				head.setData(key);
			}
			else
			{
				Node temp=head;
				Node newNode=new Node();
				newNode.setData(key);
				
				if(key <= temp.getData())
				{
					newNode.setNext(head);
					head=newNode;
					return;
				}
				else if(head.getNext()==null)
				{
					if(key > head.getData())
						{
						head.setNext(newNode);
						return;
						}
				}
				else
				{
				while((temp.getNext()).getData() < key)
					{
							temp=temp.getNext();
                     if(temp.getNext() == null)
						 break;
					}
				
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				}
				
			}
		}
}
