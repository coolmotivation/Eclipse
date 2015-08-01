package linked_list;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Linked_List {
	static Node head=new Node();
	static int count=0;
	//static Vector<Integer> v=new Vector<Integer>();
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of elements::");
			int n=Integer.parseInt(sc.nextLine());
			for(int i=0;i<n;i++)
			{  
				//v.add(sc.nextInt());
				insertion(sc.nextInt());
			}
			sc.nextLine();
			System.out.println("original linked list is::");
            printLinkedList();
            System.out.println("Linked List after reversing is::");
            reverse_linked_list();
            //delete_linked_list(head);
            /*middle_of_linked_list_method1(head);
            middle_of_linked_list_method2(head);*/
           /* System.out.printf("%d \n",length_recursively(head));
            System.out.printf("%d \n",length_iteratively(head));
            System.out.println("Enter the element to be searched::");
            int y=Integer.parseInt(sc.nextLine());
           System.out.println(search_iteratively(y));
           System.out.println(search_recursively(head,y));*/
          
           /* while(true)
            {
            	System.out.println("Enter 1:delete 2:Insertion 3:exit");
            	int t=Integer.parseInt(sc.nextLine());
            	if(t==1)
            	{
            		System.out.println("Enter the element to be deleted::");
            		delete(Integer.parseInt(sc.nextLine()));
            		printLinkedList();
            	}
            	else if(t==2)
            	{
            		System.out.println("enter the data to be inserted::");
            		insertion(Integer.parseInt(sc.nextLine()));
            		printLinkedList();
            	}
            	else
            		break;
            } */
			
		}
		public static void reverse_linked_list()
		{
			Node x=head;
			Node y=x.getNext();
			while(y != null)
			{
				Node z=y.getNext();
				y.setNext(x);
				if(x==head)
					x.setNext(null);
				x=y;
				y=z;
			}
			head=x;
			printLinkedList();
		}
		public static void delete_linked_list(Node temp)
		{
			if(temp!=null)
			{
				Node next=temp.getNext();
				temp.setData(null);
				temp.setNext(null);
				temp=null;
				temp=next;
			}
			printLinkedList();
		}
		public static void middle_of_linked_list_method1(Node temp)
		{
			int cn_e=0;
			while(temp!=null)
			{
				cn_e++;
				temp=temp.getNext();
			}
			temp=head;
			int h=0;
			while(cn_e/2 != h)
			{
				temp=temp.getNext();
				h++;
			}
			System.out.printf("Middle element is:%d\n",temp.getData());
		}
		public static void middle_of_linked_list_method2(Node temp)
		{
			Node t=head;
			while(temp!=null)
			{   if(temp.getNext()!=null)
				{
				if((temp.getNext()).getNext()!=null)
					{
					temp=(temp.getNext()).getNext();
					t=t.getNext();
					}
				}
				else
					break;
			}
			System.out.printf("The middle element is:%d\n",t.getData());
		}
		public static boolean search_iteratively(int key)
		{
			Node temp=head;
			while(temp.getData()!=key)
			{
				temp=temp.getNext();
				if(temp == null)
					break;
			}
			if(temp==null)
				return false;
			else
				return true;
		}
		public static boolean search_recursively(Node temp,int key)
		{
			if(temp==null)
				return false;
			else
			{
				if(temp.getData()==key)
					{return true;
					 
					}
				else
				{
					return search_recursively(temp.getNext(),key);		
				}
			}
		}
		public static int length_iteratively(Node temp)
		{
			int cn=0;
			while(temp!=null)
			{
				cn++;
				temp=temp.getNext();
			}
			return cn;
		}
		public static int length_recursively(Node temp)
		{  
			if(temp==null)
				return 0;
			else
			{
				return 1+length_recursively(temp.getNext());
			}
		}
		public static void printLinkedList()
		{
			Node temp=head;
			while(temp!=null)
			{
				System.out.printf("%d ",temp.getData());
				temp=temp.getNext();
			}
			System.out.println(" ");
		}
		public static void insertion(int key)
		{
			if(head.getData()== null)
			{
				head.setData(key);
			}
			else
			{
				Node temp=head;
				while(temp.getNext() != null)
					temp=temp.getNext();
				
				Node newNode=new Node();
				newNode.setData(key);
				temp.setNext(newNode);
				
			}
		}
		public static void delete(int key)
		{
			Node temp=head;
			if(head.getData() == key)
			{
				head=head.getNext();
				if(head==null)
					head=new Node();
			}
			else
			{
				while((temp.getNext()).getData() != key)
					   temp=temp.getNext();
				
					    temp.setNext((temp.getNext()).getNext());
			}
		}
}
