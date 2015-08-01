package reverse_a_stack_recursion;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class Reverse_A_Stack_using_Recursion {
		static Stack<Integer> s=new Stack<Integer>();
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the stack elements::");
			String str=sc.nextLine();
			String st[]=str.split(" ");
			int len=st.length;
			for(int i=0;i<len;i++)
			{
				s.push(Integer.parseInt(st[i]));
			}
			ListIterator it1= s.listIterator(s.size());
			
			while(it1.hasPrevious())
				{
				System.out.println(it1.previous());
				}
			reverse();
			System.out.println("After reversing the stack,we get::");
			ListIterator it= s.listIterator(s.size());
			
			while(it.hasPrevious())
				{
				System.out.println(it.previous());
				}
		}
		public static void reverse()
		{
			if(!s.isEmpty())
			{
				int temp=(int) s.pop();
				reverse();
				insert_at_bottom(temp);
			}
		}
		public static void insert_at_bottom(int key)
		{
			if(s.isEmpty())
				s.push(key);
			else
			{
				int temp=s.pop();
				insert_at_bottom(key);
				s.push(temp);
			}
		}
}
