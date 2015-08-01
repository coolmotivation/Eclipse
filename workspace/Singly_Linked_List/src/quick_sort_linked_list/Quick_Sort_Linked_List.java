package quick_sort_linked_list;

import java.util.Scanner;

public class Quick_Sort_Linked_List {
	static Node head=new Node();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements in the linked list::");
		int y=Integer.parseInt(sc.nextLine());
		for(int i=0;i<y;i++)
		{
			insertion(head,sc.nextInt());
		}
		sc.nextLine();
		printLinkedList(head);
		System.out.println("\nThe result after Quick sort is::");
		quick_sort(0,y-1);
		printLinkedList(head);
		
	}
	public static void quick_sort(int start,int end)
	{
		if(start < end)
		{
			int pivot=partition(start,end);
			quick_sort(start,pivot-1);
			quick_sort(pivot+1,end);
		}
	}
	public static int partition(int start,int end)
	{
		int count=0;
		Node ftemp=head;
		Node stemp=head;
		Node last=head;
		int y=0;
		while(y < start)
				{
			ftemp = ftemp.getNext();
			 y++;
				}
		stemp=ftemp;
		last=ftemp;
		while(y<end)
		{
			last=last.getNext();
			y++;
		}
		while(stemp!=last)
		{
			if(stemp.getData() < last.getData())
			{
				int t=ftemp.getData();
				ftemp.setData(stemp.getData());
				stemp.setData(t);
				ftemp=ftemp.getNext();
			}
			stemp=stemp.getNext();
		}
		if(stemp == last)
		{
		int t=ftemp.getData();
		ftemp.setData(last.getData());
		int find=last.getData();
		last.setData(t);
		
		Node trail=head;					//to find the final position of pivot
		while(trail.getData()!=find)
		{
			trail=trail.getNext();
			count++;
		}
		
		}
		
		return count;
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
