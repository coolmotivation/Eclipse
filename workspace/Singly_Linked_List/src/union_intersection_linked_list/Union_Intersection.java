package union_intersection_linked_list;

import java.util.Scanner;

public class Union_Intersection {
	static Node fhead=new Node();
	static Node shead=new Node();
	static Node inter=new Node();
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
		System.out.println("Enter the number of elements in the second linked list::");
		int m=Integer.parseInt(sc.nextLine());
		for(int i=0;i<m;i++)
		{
			insertion(shead,sc.nextInt());
		}
		sc.nextLine();
        
		Node temp=fhead;
		while(temp.getNext()!=null)
		{
			temp=temp.getNext();
		}
		temp.setNext(shead);
        
         merge_sort(fhead,0,n+m-1);
         classify(fhead);
         System.out.println("the union of the 2 linked list is::");
         printLinkedList(fhead);
         System.out.println("\nthe intersection of the 2 linked list is::");
         printLinkedList(inter);
         
     }
	public static void classify(Node temp)
	{
		Node first=temp;
		Node second=first.getNext();
		while(second!=null)
		{
			if(first.getData() == second.getData())
			{
				first.setNext(second.getNext());
				insertion(inter,second.getData());
				second=first.getNext();
			}
			else
			{
				first=second;
				second=second.getNext();
			}
		}
	}
	public static void merge_sort(Node thead,int start,int end)
	{
		if(start<end)
		{
			int middle=(start+end)/2;
			merge_sort(thead,start,middle);
			merge_sort(thead,middle+1,end);
			merge(thead,start,middle,end);
		}
	}
	public static void merge(Node thead,int start,int middle,int end)
	{
		Node left=new Node();
		Node right=new Node();
		Node present=null;
		int cn=0;
		while(cn!=start)
		{
			thead=thead.getNext();
			cn++;
		}//thead points to the starting node to the start of the linked list
		Node change=thead;
		cn=start;
		while(cn!=middle+1)
		{
			if(left.getData()==null)
				{
				left.setData(thead.getData());
				present=left;
				thead=thead.getNext();
				cn++;
				}
			else
			{
				Node newNode =new Node();
				newNode.setData(thead.getData());
				thead=thead.getNext();
				present.setNext(newNode);
				present=newNode;
			    cn++;
			}
		}
		cn=middle+1;
		present=null;
		present=new Node();
		while(cn!=end+1)
		{
			if(right.getData()==null)
				{
				right.setData(thead.getData());
				present=right;
				thead=thead.getNext();
				cn++;
				}
			else
			{
				Node newNode =new Node();
				newNode.setData(thead.getData());
				thead=thead.getNext();
				present.setNext(newNode);
				present=newNode;
			    cn++;
			}
		}
		Node lfirst=left;
		Node rfirst=right;
		while(lfirst!=null && rfirst!=null)
		{
			if(lfirst.getData() < rfirst.getData())
			{
				change.setData(lfirst.getData());
				change=change.getNext();
				lfirst=lfirst.getNext();
			}
			else
			{
				change.setData(rfirst.getData());
				change=change.getNext();
				rfirst=rfirst.getNext();
			}
		}
		while(lfirst!=null)
		{
			change.setData(lfirst.getData());
			change=change.getNext();
			lfirst=lfirst.getNext();
		}
		while(rfirst!=null)
		{
			change.setData(rfirst.getData());
			rfirst=rfirst.getNext();
			change=change.getNext();
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
			temp.setData(key);
		else
		{
			
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
