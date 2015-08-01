package point_to_next_higher_value;

import java.util.Scanner;

public class Point_Higher_Value {
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
		
		System.out.println("Pointing to the higher value , we get::");
		point_to_higher();
		printLinkedList(head);
	}
	public static void point_to_higher()
	{
		Node temp=head;
		while(temp!=null)
		{   boolean b =false;
			Node max=null;
			Node trial=head;
			while(trial!=null)
			{
				if(!b && temp.getData() < trial.getData())
					{
					max=trial;
					b=true;
					}
				else if(temp.getData() < trial.getData() && max.getData() > trial.getData())
					max=trial;
				trial=trial.getNext();
			}
			temp.setArb(max);
			temp=temp.getNext();
		}
	}
	public static void printLinkedList(Node temp)
	{   
		while(temp!=null)
		{
			System.out.printf("%d : ",temp.getData());
			if(temp.getArb()!=null)
				System.out.printf("%d ",(temp.getArb()).getData());
			temp=temp.getNext();
			System.out.println(" ");
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
			
		}
	}
}
