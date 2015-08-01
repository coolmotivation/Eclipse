package special_stack;
import java.util.Scanner;
import java.util.Stack;

public class Special_Stack {
		static Stack<Integer> s1=new Stack<Integer>();
		static Stack<Integer> s2=new Stack<Integer>();
	     public static void main(String args[])
	     {
	    	 Scanner sc=new Scanner(System.in);
	    	 System.out.println("Enter the numbers to be inserted in this special stack::");
	    	 String str=sc.nextLine();
	    	 String st[]=str.split(" ");
	    	 for(int i=0;i<st.length;i++)
	    	 {
	    		 push_special_stack(Integer.parseInt(st[i]));
	    	 }
	    	 while(true)
	    	 {
	    		 System.out.println("Enter 1:pop 2:get Minimum 3:exit");
	    		 int n=Integer.parseInt(sc.nextLine());
	    		 if(n==1)
	    		 {
	    			 pop_special_stack();
	    		 }
	    		 else if(n==2)
	    		 {
	    			 get_min();
	    		 }
	    		 else if(n==3)
	    			 break;
	    	 }
	    	 sc.close();
	     }
	     public static void push_special_stack(int key)
	     {
	    	 if(s1.isEmpty())
	    	 {
	    		 s1.push(key);
	    		 s2.push(key);
	    	 }
	    	 else
	    	 {
	    		 if(!s2.isEmpty())
	    		 {
	    			 int t=s2.peek();
	    			 if(key < t)
	    			 {
	    				 s1.push(key);
	    				 s2.push(key);
	    			 }
	    			 else
	    			 {
	    				 s1.push(key);
	    				 s2.push(t);
	    			 }
	    		 }
	    	 }
	     }
	     public static void pop_special_stack()
	     {
	    	 if(!s2.isEmpty())
	    		 s2.pop();
	    	 int t=s1.peek();
	    	 s1.pop();
	    	 System.out.printf("The popped element is::%d\n",t);
	     }
	     public static void get_min()
	     {  
	    	 if(!s2.isEmpty())
	    	 System.out.printf("The minimum element is::%d\n",s2.peek());
	    	 else
	    		 System.out.println("Stack Underflow Error!!!");
	     }
}
