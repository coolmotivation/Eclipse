package postfix_evaluation_multi_digit;

import java.util.Scanner;
import java.util.Stack;

public class Postfix_evaluation_Multi_Digit {
	static Stack<Integer> s=new Stack<Integer>();
 	public static void main(String args[])
 	{
 		Scanner sc=new Scanner(System.in);
 		System.out.println("Enter the postfix expression,you can enter 2-3 digit numbers too but with space in between::");
 		String str=sc.nextLine();
 		postfix_evaluation(str);
 		System.out.println(s.pop());
 		sc.close();
 	}
 	public static void postfix_evaluation(String str)
 	{
 		
 		String[] st=str.split(" ");
 		int len=st.length;
 		//System.out.println(len);
 		for(int i=0;i<len;i++)
 		{
 			String c=st[i];
 			
 			//System.out.println(t);
 			if(c.equals("+") || c.equals("-")|| c.equals("*")|| c.equals("/") || c.equals("%"))
 			{
 				int a=s.pop();
 				int b=s.pop();
 				if(c.equals("+"))
 					s.push(a+b);
 				else if(c.equals("-"))
 					s.push(b-a);
 				else if(c.equals("*"))
 					s.push(a*b);
 				else if(c.equals("/"))
 					s.push(b/a);
 				else if(c.equals("%"))
 					s.push(b%a);
 			}
 			else 
 			{
 				int t=Integer.parseInt(c);
 				s.push(t);
 			}
 				
 		}
 	}
}
