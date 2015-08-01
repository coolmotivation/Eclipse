package add_linked_list;

import java.util.Scanner;

import delet_nodes_with_greater_value_on_right.Node;

public class Add_Linked_List {
	static Node fhead=new Node();
    static Node shead=new Node();
    static Node thead=new Node();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements in the first linked list::");
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			insertion(fhead,sc.nextInt());
		}
		sc.nextLine();
		printLinkedList(fhead);
		System.out.println(" ");
		System.out.println("Enter the number of elements in the second linked list::");
		n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			insertion(shead,sc.nextInt());
		}
		sc.nextLine();
		printLinkedList(shead);
         System.out.println(" ");
         System.out.println("\nAdding 2 linked list,we get::");
         add_linked_list();
         printLinkedList(thead);
     }
	public static void add_linked_list()
	{
		Node ftemp=fhead;
		Node stemp=shead;
		boolean check=false;
		int carry=0;
		
		while(ftemp!=null && stemp!=null)
		{
		   int add=ftemp.getData()+stemp.getData()+carry;
		   insertion(thead,add%10);
		   carry=add/10;
		   if(carry!=0)
			   check=true;
		   else
			   check=false;
		   ftemp=ftemp.getNext();
		   stemp=stemp.getNext();
		   
		}
		while(ftemp!=null && stemp==null)
		{
			int add=ftemp.getData()+carry;
			insertion(thead,add%10);
			carry=add/10;
			if(carry!=0)
				check=true;
			else
				check=false;
			ftemp=ftemp.getNext();
		}
		while(stemp!=null && ftemp==null)
		{
			int add=stemp.getData()+carry;
			insertion(thead,add%10);
			carry=add/10;
			if(carry!=0)
				check=true;
			else
				check=false;
			stemp=stemp.getNext();
		}
		if(check==true)
		{
			insertion(thead,carry);
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
			//System.out.println(newNode.getData());
		}
	}

}
