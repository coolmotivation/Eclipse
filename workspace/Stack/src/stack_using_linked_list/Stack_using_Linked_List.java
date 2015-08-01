package stack_using_linked_list;
import java.util.Scanner;

public class Stack_using_Linked_List {
		static Node head=new Node();
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("Enter 1:Push 2:Pop 3:Peek 4:Exit");
				int n=Integer.parseInt(sc.nextLine());
				if(n==4)
					break;
				switch(n)
				{
				case 1:
				{
					System.out.println("Enter the element to be inserted::");
					int key=Integer.parseInt(sc.nextLine());
					push(key);
					printLinkedList(head);
					break;
				}
				case 2:
				{
					pop();
					break;
				}
				case 3:
				{
					peek();
					break;
				}
				
				}
			}
		}
		public static void printLinkedList(Node temp)
		{
			while(temp!=null)
			{
				System.out.printf("%d ",temp.getData());
				temp=temp.getNext();
			}
			System.out.println(" ");
		}
		public static void push(int key)
		{
			if(head.getData()==null)
				{
				head.setData(key);
				}
			else
			{
				Node newNode=new Node();
				newNode.setData(key);
				newNode.setNext(head);
				head=newNode;
			}
		}
		public static void pop()
		{
			if(head.getData()==null)
			{
				System.out.println("Stack Underflow Error");
				return;
			}
			else
			{
				System.out.printf("The popped element is::%d\n",head.getData());
				if(head.getNext()==null)
					head.setData(null);
				else
					head=head.getNext();
			}
		}
		public static void peek()
		{
			if(head.getData()==null)
			{
				System.out.println("Stack Underflow Error");
				return;
			}
			else
			{
				System.out.printf("The top element is::%d\n",head.getData());
			}
		}
}
