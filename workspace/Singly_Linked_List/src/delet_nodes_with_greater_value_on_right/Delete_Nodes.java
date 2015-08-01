package delet_nodes_with_greater_value_on_right;

import java.util.Scanner;

public class Delete_Nodes {
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
         
         System.out.println("\nDeleting the nodes if they have greater value on right side,we get::");
         delete_node_if_greater_value_on_right();
         printLinkedList(head);
     }
	public static void delete_node_if_greater_value_on_right()
	{
		Node current=head;
		Node prev=null;
		Node next=null;
		boolean check=false;
		while(current.getNext()!=null)
		{
			next=current.getNext();
			while(next!=null)
			{
				if(next.getData() < current.getData())
					{
					next=next.getNext();
					check=false;
					continue;
					}
				else    //delete the node current
				{
					if(current==head)
					{
						head=head.getNext();
						current=head;
						check=true;
						break;
					}
					else
					{
						prev.setNext(current.getNext());
						current=prev.getNext();
						check=true;
						break;
					}
				}
			}
			if(!check)
			{
			prev=current;
			current=current.getNext();
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
