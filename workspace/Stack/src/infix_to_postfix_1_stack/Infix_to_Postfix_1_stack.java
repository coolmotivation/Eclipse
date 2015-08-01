package infix_to_postfix_1_stack;

import java.util.Scanner;
import java.util.Stack;

public class Infix_to_Postfix_1_stack {
	static Stack<Character> s=new Stack<Character>();
	
	public static void main(String args[])
	{     
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		infix_to_postfix_using_1_stack(str);
		sc.close();
	}
	public static void infix_to_postfix_using_1_stack(String str)
	{
	  int len=str.length();
	  for(int i=0;i<len;i++)
	  {
		char c=str.charAt(i);
		if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^')
		{
			if(!s.isEmpty())
			{
				while(getPrecedence(c) < getPrecedence(s.peek()))
				{
					System.out.printf("%c",s.pop());
					if(s.isEmpty())
						break;
				}
			}
			s.push(c);						//((2/4)*6)+((8*9)+5)
		}
		else if(c=='(')
			s.push(c);
		else if(c==')')
		{
			while(s.peek()!='(')
			{
				System.out.printf("%c",s.pop());
			}
			s.pop();
		}
		else
		{
			System.out.printf("%c",c);
		}
		  
	  }
	  while(!s.isEmpty())
		  System.out.printf("%c",s.pop());
	}
	public static int getPrecedence(char c)
	{
	   switch(c)
	   {
	   case '+':
		      return 2;
	   case '-':
		      return 1;
	   case '*':
		      return 3;
	   case '/':
		      return 4;
	   case '^':
		      return 5;
	   case '(':
		   	  return 0;
	   case ')':
		      return 0;
	   }
	   return 0;
	}
}
