package hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pompom_Love_Story {
		public static void main(String args[]) throws NumberFormatException, IOException
		{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            long n=Integer.parseInt(br.readLine());
            for(long i=0;i<n;i++)
            {
            	String s=br.readLine();
            	int[] arr=new int[123];
            	int len=s.length();
            	for(long j=0;j<len;j++)
            	{
            		int h=s.charAt((int)j);
            		arr[h]++;
            	}
            	int cn=0;
            	for(int j=97;j<123;j++)
            	{
            		if(arr[j]>0)
            		{
            			cn++;
            		}
            	}
            	String st ="";
            	for(int j=97;j<123;j++)
            	{
            		if(arr[j]>0)
            		{
            			int g=arr[j];
            			while(g>0)
            			 {
            				st= st + (char)j;
            				g--;
            			 }
            		}
            	}
            	if(cn%2!=0)
            	{
            		System.out.println("Girl");
            		
            	}
            	else
            	{
            		System.out.println("Boy");
            	}
            	StringBuilder sb=new StringBuilder(st);
        		sb.reverse();
        		
        		Character t=sb.charAt(0);
        		sb.deleteCharAt(0);
        		t=t.toUpperCase(t);
        		
        		sb.insert(0,t);
        		System.out.println(sb);
            }
            
		}
}
/*
2
abcdefgh
acbde
*/