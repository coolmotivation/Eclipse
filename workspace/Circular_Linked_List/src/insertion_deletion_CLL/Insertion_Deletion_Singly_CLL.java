package insertion_deletion_CLL;
import java.util.Scanner;

public class Insertion_Deletion_Singly_CLL {
		static Node head=new Node();
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the numner of elements::");
			int n=Integer.parseInt(sc.nextLine());
			for(int i=0;i<n;i++)
			{
				insertion(sc.nextInt());
			}
			sc.nextLine();
			System.out.println("the Singly Circular linked list entered till now is::");
			printLinkedList();
			while(true)
			{
			System.out.println("\nEnter 1:Insert_start 2:Insert_end 3:Insert_before 4:Insert_after 5:deletion 6:Simply insert 7:exit");
			int k=Integer.parseInt(sc.nextLine());
			if(k==7)
				break;
				switch(k)
				{
					case 1:
					{
					  System.out.println("Enter the element to be inserted::");
					  int key=Integer.parseInt(sc.nextLine());
					  insert_beginning(key);
					  
					  break;
					}
					case 2:
					{
						System.out.println("Enter the element to be inserted::");
						int key=Integer.parseInt(sc.nextLine());
						insert_end(key);
						break;
					}
					case 3:
					{
						System.out.println("Enter the element and element before which to be inserted::");
						int a=sc.nextInt();
						int b=sc.nextInt();
						sc.nextLine();
						insert_before(a,b);
						break;
					}
					case 4:
					{
						System.out.println("Enter the element and element after which to be inserted::");
						int a=sc.nextInt();
						int b=sc.nextInt();
						sc.nextLine();
						insert_after(a,b);
						break;
					}
					case 5:
					{
						System.out.println("Enter the element to be deleted::");
						int key=Integer.parseInt(sc.nextLine());
						delete(key);
						break;
					}
					case 6:
					{
						System.out.println("Enter the element to be inserted::");
						int key=Integer.parseInt(sc.nextLine());
						insertion(key);
						break;
					}
				}
			printLinkedList();
			}
		}
		public static void delete(int key)
		{
			Node temp=head;
			Node ptemp=null;
			Node ntemp=null;
			if(head.getData()==key)
			{
				if(head.getNext()==head)
				{
					head.setData(null);
					return;
				}
				Node d=head;
				while(d.getNext()!=head)
				{
					d=d.getNext();
				}
				
				d.setNext(head.getNext());
				head=head.getNext();
				return;
			}
			else
			{  ptemp=head;
			   temp=head.getNext();
				while(temp != head)
				{  
					ntemp=temp.getNext();
					if(temp.getData()==key)
					{
					  ptemp.setNext(ntemp);
					  return;
					}
					ptemp=temp;
					temp=temp.getNext();
				}
			}
		}
		public static void insert_beginning(int key)
		{
			Node newNode=new Node();
			  newNode.setData(key);
			  if(head.getData()==null)
				  {
				  head=newNode;
				  head.setNext(head);
				  return;
				  }
			  Node temp=head;
			  while(temp.getNext()!=head)
				  temp=temp.getNext();
			  temp.setNext(newNode);
			  newNode.setNext(head);
			  head=newNode;
		}
		public static void insert_end(int key)
		{
			Node newNode=new Node();
			newNode.setData(key);
			Node temp=head;
			while(temp.getNext()!=head)
				temp=temp.getNext();
			temp.setNext(newNode);
			newNode.setNext(head);
		}
		public static void insert_before(int a,int b)
		{
			Node temp=head;
			if(temp.getData() == b)
				{
				insert_beginning(a);
				return;
				}
			Node ntemp=temp.getNext();
			Node newNode=new Node();
			newNode.setData(a);
			
			while(ntemp != head)
			{
				if(ntemp.getData()==b)
				{
					temp.setNext(newNode);
					newNode.setNext(ntemp);
					return;
				}
				temp=ntemp;
				ntemp=ntemp.getNext();
			}
			Node ptemp=null;
			if(temp.getData() == b)
			{
				
				temp=head;
				
				while(temp.getNext()!=head)
				{
				   ptemp=temp;
				   temp=temp.getNext();
				}
				ptemp.setNext(newNode);
				newNode.setNext(temp);
			}
		}
		public static void insert_after(int a,int b)
		{
		   Node temp=head;
		   Node ntemp=null;
		   Node newNode=new Node();
		   newNode.setData(a);
		   while(temp.getNext()!=head)
		   {
			   ntemp=temp.getNext();
			   if(temp.getData()==b)
			   {
				   temp.setNext(newNode);
				   newNode.setNext(ntemp);
				   return;
			   }
			   temp=ntemp;
		   }
		   if(temp.getData()==b)
			   insert_end(a);
		}
		public static void printLinkedList()
		{
			Node temp=head;
			if(head==null)
			{
			System.out.println("null");
			return;
			}
			if(head.getData()!=null)
				System.out.printf("%d ",temp.getData());
			
			
			temp=temp.getNext();
			while(temp!=head)
			{   
				System.out.printf("%d ",temp.getData());
				temp=temp.getNext();
			}
			
		}
		public static void insertion(int key)
		{
			 if(head.getData()==null)
			{  
				head.setData(key);
				head.setNext(head);
			}
			else
			{
				Node temp=head;
				while(temp.getNext()!=head)
				{
					temp=temp.getNext();
				}
				Node newNode=new Node();
				newNode.setData(key);
				temp.setNext(newNode);
				newNode.setNext(head);
			}
		}
}
