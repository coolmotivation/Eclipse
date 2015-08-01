package infix_to_postfix;

import java.util.Scanner;
import java.util.Stack;

public class Infix_to_Postfix_using_2_stacks {
	static Stack<Character> s1=new Stack<Character>();
	static Stack<Character> s2=new Stack<Character>();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		infix_to_postfix(s);
		sc.close();
	}
	public static void infix_to_postfix(String s)
	{
		
		int len=s.length();
		for(int i=0;i<len;i++)
		{
			char c=s.charAt(i);
			if(c=='+' || c=='*' || c=='/' || c=='-')
			{
				s2.push(c);
				continue;
			}
			if(c=='(')
				continue;
			if(c==')')									//((2/4)*6)+((8*9)+5)
				{
				s1.push(s2.pop());
				continue;
				}
			s1.push(c);
		}
		while(!s1.isEmpty())
		{
			s2.push(s1.pop());
		}
		while(!s2.isEmpty())
			System.out.printf("%c",s2.pop());
	}
}
