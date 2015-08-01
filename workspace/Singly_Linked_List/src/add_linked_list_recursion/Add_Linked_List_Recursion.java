package add_linked_list_recursion;

import java.util.Scanner;

public class Add_Linked_List_Recursion {
	static Node fhead=new Node();
    static Node shead=new Node();
     static int count=0;
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
		if(n<m)
		{
			int y=0;
			while(y!=m-n)
			{
				Node newNode=new Node();
				newNode.setData(0);
				newNode.setNext(fhead);
				fhead=newNode;
				y++;
			}
		}
		else if(m<n)
		{
			int y=0;
			while(y!=n-m)
			{
				Node newNode=new Node();
				newNode.setData(0);
				newNode.setNext(shead);
				shead=newNode;
				y++;
			}
		}
         System.out.println("Adding 2 linked list,we get::");
        System.out.printf("%d ",add_linked_list(fhead,shead,0));
        
     }
	public static int add_linked_list(Node ftemp,Node stemp,int carry)
	{
	    if(ftemp==null && stemp==null && carry==0)
	    	return 0;
	    else
	    {   
	    	int prevadd = 0;
	    	if(ftemp!=null && stemp!=null)
	    		prevadd=add_linked_list(ftemp.getNext(),stemp.getNext(),carry);
	    	else if(ftemp==null && stemp!=null)
	    		prevadd=add_linked_list(null,stemp.getNext(),carry);
	    	else if(ftemp!=null && stemp==null)
	    		prevadd=add_linked_list(ftemp.getNext(),null,carry);
	    	
	    	
	    	if(ftemp!=null && stemp!=null)
	    		 {
	    		int y= ftemp.getData() + stemp.getData() + carry;
	    		prevadd = prevadd + y * (int)Math.pow(10, count);	
	    		 }
	    	else if(ftemp!=null && stemp==null)
	    		  {  int y=ftemp.getData() + carry;
	    		  prevadd = prevadd + y * (int)Math.pow(10, count);	
	    		  }
	    	else if(ftemp==null && stemp!=null)
	    	{
	    		int y=stemp.getData() + carry;
	    		 prevadd = prevadd + y * (int)Math.pow(10, count);
	    	}
	    		
	    	count++;
	    	return prevadd;
	    	
	    	
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
