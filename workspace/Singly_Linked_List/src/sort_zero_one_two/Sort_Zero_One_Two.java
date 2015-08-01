package sort_zero_one_two;

import java.util.Scanner;

import add_linked_list_recursion.Node;

public class Sort_Zero_One_Two {
	static Node fhead=new Node();
    
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
		sort_0_1_2();
		System.out.println("After sorting::");
		printLinkedList(fhead);
	}
	public static void sort_0_1_2()
	{
		int n0=0,n1=0,n2=0;
		Node temp=fhead;
		while(temp!=null)
		{
			if(temp.getData()==0)
				n0++;
			else if(temp.getData()==1)
				n1++;
			else
				n2++;
			temp=temp.getNext();
		}
		temp=fhead;
		int y=0;
		while(y!=n0 && temp!=null)
		{
			temp.setData(0);
			temp=temp.getNext();
			y++;
		}
		y=0;
		while(y!=n1 && temp!=null)
		{
			temp.setData(1);
			temp=temp.getNext();
			y++;
		}
		y=0;
		while(y!=n2 && temp!=null)
		{
			temp.setData(2);
			temp=temp.getNext();
			y++;
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
