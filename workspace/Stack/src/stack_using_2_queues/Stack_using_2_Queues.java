package stack_using_2_queues;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;

public class Stack_using_2_Queues {
		static Queue<Integer> q1= new PriorityQueue<Integer>();
		static Queue<Integer> q2= new PriorityQueue<Integer>();
		static String active;
		static int cn=0;
		public static void main(String args[])
		{   
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("Enter 1:push 2:pop 3:peek 4:Exit");
				int n=Integer.parseInt(sc.nextLine());
				if(n==4)
					break;
				switch(n)
				{
				case 1:
					{
					   System.out.println("Enter the element to be pushed::");
					   int key=Integer.parseInt(sc.nextLine());
					   push(key);
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
		public static void push(int key)
		{
				q1.add(key);
		}
		public static void pop()
		{ 
			while(!q1.isEmpty() && q1.size()!=1)
				q2.add(q1.remove());
			System.out.printf("The popped element is::%d\n",q1.remove());
			q1.addAll(q2);
			q2.clear();
		}
		public static void peek()
		{ 
			while(!q1.isEmpty() && q1.size()!=1)
				q2.add(q1.remove());
			System.out.printf("The top element is::%d\n",q1.peek());
			q2.add(q1.remove());
			q1.addAll(q2);
			q2.clear();
		}
}
