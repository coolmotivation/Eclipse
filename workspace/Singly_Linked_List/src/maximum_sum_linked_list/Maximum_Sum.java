package maximum_sum_linked_list;

import java.util.Scanner;

import merge_linked_list_alternate.Node;

public class Maximum_Sum {
	static Node fhead=new Node();
	static Node shead=new Node();
	static Node result=new Node();
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
		
		System.out.println("Enter the number of elements in the second linked list::");
		y=Integer.parseInt(sc.nextLine());
		for(int i=0;i<y;i++)
		{
			insertion(shead,sc.nextInt());
		}
		sc.nextLine();
		max_sum();
		printLinkedList(result);
		
	}
	public static void max_sum()
	{   
		Node ftemp=fhead;
		Node stemp=shead;
		while(ftemp!=null && stemp!=null)
		{   
			int sum1=0;int sum2=0;
			Node pftemp = ftemp;
			Node pstemp = stemp;
			
			while(ftemp!=null && stemp!=null)
			{  
				if(ftemp.getData() < stemp.getData())
					{
							if(ftemp.getNext()!=null)
								ftemp=ftemp.getNext();
							else 
								break;
					}
				else if(ftemp.getData() > stemp.getData())
					  {
							if(stemp.getNext()!=null)
								stemp=stemp.getNext();
							else
								break;
					  }
				else
					     break;
			}// by this loop we will get the first common nodes in both the linked list
			
			Node a=pftemp;
			Node b=ftemp;
			Node c=pstemp;
			Node d=stemp;
			
			while(pftemp!=ftemp.getNext() && pftemp!=null)
			{  
				sum1=sum1+pftemp.getData();
				pftemp=pftemp.getNext();
				
			}
			while(pstemp!=stemp.getNext() && pstemp!=null)
			{  
				sum2=sum2+pstemp.getData();
				pstemp=pstemp.getNext();
			}
			if(sum1 < sum2)
			{  
				append_result(shead,c,d);
			}
			else if(sum1 > sum2)
			{   
				append_result(fhead,a,b);
			}
			else if(sum1 == sum2)
			{   
				append_result(fhead,a,b);
			}
			ftemp=ftemp.getNext();
			stemp=stemp.getNext();
		}
		if(ftemp!=null && stemp==null)
		{
			Node f=ftemp;
			while(f.getNext()!=null)
			{
				f=f.getNext();
			}
			append_result(fhead,ftemp,f);
		}
		if(stemp!=null && ftemp==null)
		{
			Node f=stemp;
			while(f.getNext()!=null)
			{
				f=f.getNext();												//1 3 30 90 120 240 511
			}																//0 3 12 32 90 125 240 249
			append_result(shead,stemp,f);
		}
	}
	public static void append_result(Node list,Node start,Node end)
	{
		Node temp=list;
		while(temp!=start)
		{
			temp=temp.getNext();
		}
			
		while(temp!=end.getNext())
		{
			insertion(result,temp.getData());
			
			temp=temp.getNext();
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
			
		}
	}
}
