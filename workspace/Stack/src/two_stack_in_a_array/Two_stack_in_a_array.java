package two_stack_in_a_array;
import java.util.Scanner;

public class Two_stack_in_a_array {
		static int[] arr=new int[20];
		static int first=-1;
		static int second=20;
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the elements for the first stack::");
			String st=sc.nextLine();
			String s[]=st.split(" ");
			int len=s.length;
			for(int i=0;i<len;i++)
			{
				push_stack(1,Integer.parseInt(s[i]));
			}
			System.out.println("Enter the elements for the second stack::");
			st=sc.nextLine();
			String s1[]=st.split(" ");
			len=s1.length;
			for(int i=0;i<len;i++)
			{
				push_stack(2,Integer.parseInt(s1[i]));
			}
			while(true)
			{
				System.out.println("Enter 1:push  2:pop 3:peek 4:exit");
				int n=Integer.parseInt(sc.nextLine());
				switch(n)
				{
					case 1:
					{
						System.out.println("Enter the the stack number and key to be inserted::");
						int h=sc.nextInt();
						int w=sc.nextInt();
						sc.nextLine();
						push_stack(h,w);
						break;
					}
					case 2:
					{
						System.out.println("Enter the the stack number from which the element is to be popped::");
						int h=Integer.parseInt(sc.nextLine());
						pop_stack(h);
						break;
					}
					case 3:
					{
						System.out.println("Enter the stack number from which element is to be peeked::");
						int h=Integer.parseInt(sc.nextLine());
						peek_stack(h);
						break;
					}
					case 4:
					{
						System.exit(0);
					}
				}

				for(int i=first;i>=0;i--)								//1 2 3 4 5 6 7 8 9 10
					System.out.printf("%d ",arr[i]);				//11 12 13 14 15 16 17 18 19
				System.out.println("");

				for(int i=second;i<=19;i++)
					System.out.printf("%d ",arr[i]);
				System.out.println("");
			}
			
		}
		public static void push_stack(int stack,int key)
		{
			if(stack==1)
			{
				first++;
				if(first == second)
				{
					System.out.println("Stack Overflow Error");
					first--;
					return;
				}
				arr[first]=key;
			}
			else
			{
				second--;
				if(second == first)
				{
					System.out.println("Stack Overflow Error");
					second++;
					return;
				}
				arr[second]=key;
			}
		}
		public static void pop_stack(int stack)
		{
			if(stack ==1)
			{   if(first>=0)
					{
				      System.out.printf("The element popped from 1st stack is::%d\n",arr[first]);
				      first--;
					}
				else
					{
					System.out.println("Stack Underflow Error");
					return;
					}
			    
			}
			else
			{    
				if(second < 20)
						{
							System.out.printf("the element popped from 2nd stack is::%d\n",arr[second]);
							second++;
						}
				else
				{
					System.out.println("Stack Underflow Error");
				}
			}
		}
		public static void peek_stack(int stack)
		{
			if(stack ==1)
			{   if(first >= 0)
					System.out.printf("the top element in 1st stack is::%d\n",arr[first]);
				else
				     System.out.println("Stack Underflow Error");
			}
			else
			{
				if(second <20)
					System.out.printf("the top element in 2st stack is::%d\n",arr[second]);
				else
				     System.out.println("Stack Underflow Error");
			}
		}
}
