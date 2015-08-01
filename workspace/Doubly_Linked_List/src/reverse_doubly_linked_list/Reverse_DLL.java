package reverse_doubly_linked_list;

import java.util.Scanner;

public class Reverse_DLL {
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
		  
		  System.out.println("\nLinked List from the front will look like::");
		  printLinkedList(head);
		  
		  System.out.println("\nLinked List after reversing by changing the links will become::");
		  reverse_by_changing_links(head);
		  printLinkedList(head);
		  
		  System.out.println("\nLinked List after reversing by changing data will become::");
		  reverse_by_changing_data(n);
		  printLinkedList(head);
		  sc.close();
	  }
	  public static void reverse_by_changing_data(int n)
	  {
		  Node start=head;
		  Node last=tail;
		  int k=n/2;
		  int cn=0;
		  while(cn!=k)
		  {
			  int t=start.getData();
			  start.setData(last.getData());
			  last.setData(t);
			  
			  start=start.getNext();
			  last=last.getPrev();
			  cn++;
		  }
	  }
	  public static void reverse_by_changing_links(Node temp)
	  {		  
		  while(temp!=null)
		  {  
			  Node ntemp=temp.getNext();
			  temp.setNext(temp.getPrev());
			
			  if(temp.getPrev()!=null)
				  temp.getNext().setPrev(temp);
			  else
			  { tail=temp;
			    tail.setNext(null);
			  }
			  
			  if(ntemp==null)
				  {
				  head=temp;
				  head.setPrev(null);
				  }
			  temp=ntemp;
		  }
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
