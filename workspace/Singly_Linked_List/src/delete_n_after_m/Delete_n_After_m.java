package delete_n_after_m;

import java.util.Scanner;

public class Delete_n_After_m {
static Node fhead=new Node();
    
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements in the first linked list::");
		int y=Integer.parseInt(sc.nextLine());
		for(int i=0;i<y;i++)
		{
			insertion(fhead,sc.nextInt());
		}
		sc.nextLine();
		System.out.println("Enter the value of m and n::");
		int m=sc.nextInt();
		int n=sc.nextInt();
		delete_n(m,n);
		printLinkedList(fhead);
	}
	public static void delete_n(int m,int n)
	{
		Node temp=fhead;
		Node ntemp=fhead;
		while(temp!=null && ntemp!=null)
		{
			int cn=0;
			while(cn!=m-1)
			{
				temp=temp.getNext();
				cn++;
			}
			cn=0;
			ntemp=temp;
			while(cn!=n+1)
			{
				ntemp=ntemp.getNext();
				if(ntemp==null)
					{
					temp.setNext(null);
					break;
					}
				cn++;
			}
			temp.setNext(ntemp);
			temp=ntemp;
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
