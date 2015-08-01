package doubly_linked_list;
import java.util.Scanner;

public class DLL_Implementation {
	static Node head=new Node();
	static Node tail=new Node();
	  public static void main(String args[])
	  {
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the number of elements::");
		  int n=Integer.parseInt(sc.nextLine());
		  for(int i=0;i<n;i++)
		  {
			  insertion(head,sc.nextInt());
		  }
		  sc.nextLine();
		  
		  System.out.println("Linked List from the front will look like::");
		  printLinkedList(head);
		 
		  System.out.println("\nEnter 1:Insert_front 2:Insert_end 3:Insert_before 4:Insert_after 5:delete else:exit");
		 int t=Integer.parseInt(sc.nextLine());
		 while(true)
		 {
			 	switch(t)
			 	{
			 		case 1:
			 		{
			 			System.out.println("Enter the element to be inserted at front::");
			 			int key=Integer.parseInt(sc.nextLine());
			 			Node newNode=new Node();
			 			newNode.setData(key);
			 			newNode.setNext(head);
			 			head.setPrev(newNode);
			 			head=newNode;
			 			break;
			 		}
			 		case 2:
			 		{
			 			System.out.println("Enter the element to be inserted at end::");
			 			int key=Integer.parseInt(sc.nextLine());
			 			Node newNode=new Node();
			 			newNode.setData(key);
			 			tail.setNext(newNode);
			 			newNode.setPrev(tail);
			 			tail=newNode;
			 			break;
			 		}
			 		case 3:
			 		{
			 			System.out.println("Enter the element and before which element::");
			 			int a=sc.nextInt();
			 			int b=sc.nextInt();
			 			sc.nextLine();
			 			insert_before(a,b);
			 			break;
			 		}
			 		case 4:
			 		{
			 			System.out.println("Enter the element and after which element::");
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
			 	}
			 	printLinkedList(head);
			 	System.out.println(" ");
			 	System.out.println("Enter 1:Insert_front 2:Insert_end 3:Insert_before 4:Insert_after 5:delete 6:exit");
			 	t=Integer.parseInt(sc.nextLine());
			 	if(t==6)
			 		break;
		 }
		 printLinkedList(head);
		 System.out.println(" ");
		 printLinkedList(tail);
	 sc.close();
	  }
	  public static void delete(int key)
	  {
		  Node temp=head;
		  while(temp.getData()!=key)
		  {
			  temp=temp.getNext();
		  }
		  Node ptemp=temp.getPrev();
		  Node ntemp=temp.getNext();
		  if(ptemp==null)
		  {
			  head=ntemp;
			  ntemp.setPrev(null);
			  return;
		  }
		  else if(ntemp==null)
		  {
			  tail=tail.getPrev();
			  tail.setNext(null);
			  return;
		  }
		  else
		  {
			  ptemp.setNext(ntemp);
			  ntemp.setPrev(ptemp);
		  }
	  }
	  public static void insert_before(int key,int ele)
	  {
		  Node temp=head;
		  while(temp.getData()!=ele)
			  temp=temp.getNext();
		  
		  Node prev=temp.getPrev();
		  
		  Node newNode=new Node();
		  newNode.setData(key);
		  
		  if(prev!=null)
		  prev.setNext(newNode);
		  else
			  head=newNode;
		  newNode.setPrev(prev);
		  
		  newNode.setNext(temp);
		  temp.setPrev(newNode);
	  }
	  public static void insert_after(int key,int ele)
	  {
		  Node temp=head;
		  while(temp.getData()!=ele)
		  {
			  temp=temp.getNext();
		  }
		  Node ptemp=temp;
		  Node ntemp=temp.getNext();
		  
		  Node newNode=new Node();
		  newNode.setData(key);
		  
		  ptemp.setNext(newNode);
		  newNode.setPrev(ptemp);
		  
		  newNode.setNext(ntemp);
		  if(ntemp!=null)
			  ntemp.setPrev(newNode);
		  else
			  tail=newNode;
	  }
	  public static void printLinkedList(Node temp)
	  {
		  if(temp==head)
		  {
			  while(temp!=null)
			  {
				  System.out.printf("%d ",temp.getData());
				  temp=temp.getNext();
			  }
		  }
		  else if(temp==tail)
		  {
			  while(temp!=null)
			  {
				  System.out.printf("%d ",temp.getData());
				  temp=temp.getPrev();
			  }
		  }
	  }
	  public static void insertion(Node temp,int key)
	  {
		  if(temp.getData()==null)
		  {
			  temp.setData(key);
			  tail=temp;
		  }
		  else
		  {
			  Node t=head;
			  while(t.getNext()!=null)
			  {
				  t=t.getNext();
			  }
			  Node newNode=new Node();
			  newNode.setData(key);
			  t.setNext(newNode);
			  newNode.setPrev(t);
			  tail=newNode;
		  }
	  }
}
