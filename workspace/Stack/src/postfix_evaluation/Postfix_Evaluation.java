package postfix_evaluation;
import java.util.Scanner;
import java.util.Stack;

public class Postfix_Evaluation {
	
	static Stack<Integer> s=new Stack<Integer>();
	 	public static void main(String args[])
	 	{
	 		Scanner sc=new Scanner(System.in);
	 		System.out.println("Enter the postfix expression::");
	 		String str=sc.nextLine();
	 		postfix_evaluation(str);
	 		System.out.println(s.pop());
	 		sc.close();
	 	}
	 	public static void postfix_evaluation(String str)
	 	{
	 		int len=str.length();
	 		for(int i=0;i<len;i++)
	 		{
	 			char c=str.charAt(i);
	 			int t=(int)c - '0' ;
	 			//System.out.println(t);
	 			if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
	 			{
	 				int a=s.pop();
	 				int b=s.pop();
	 				if(c == '+')
	 					s.push(a+b);
	 				else if(c == '-')
	 					s.push(b-a);
	 				else if(c == '*')
	 					s.push(a*b);
	 				else if(c == '/')
	 					s.push(b/a);
	 				else if(c == '%')
	 					s.push(b%a);
	 			}
	 			else 
	 				s.push(t);
	 		}
	 	}
}
