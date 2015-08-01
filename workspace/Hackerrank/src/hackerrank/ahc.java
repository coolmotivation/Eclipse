package hackerrank;

import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BuffredReader;
public class ahc
{
    public static void main(String ar[])
    {
      Scanner in=new Scanner(System.in);
     
      int t=in.nextInt();
      
      String sss = "";
      String s[]=new String[t];
      String ss[]=new String[t];
      in.nextLine();
      for(int i=0;i<t;i++)
      {
		  s[i]=in.nextLine();
      }
      
      //int sort[]=new int[t];
      
      for(int i=0;i<t;i++)
      {
		  int x=s[i].length();
		
		  int sort[]=new int[x];
		  if(x % 2==0)
		  {
			 
			  System.out.println("Boy");
		  }
		  else
		  {
			 
			  System.out.println("Girl");
		  }
		  
		 // int xx=s[i].charAt(x-1)-32;
		 
		  
		  for(int j=0;j<x;j++)
		  {
			  sort[j]=s[i].charAt(j);
			 
		  }
		  
		  sort=heapsort(sort);
		 
		  
		  sort[0]=sort[0]-32;
		  
		  for(int j=0;j<x;j++)
		  {
			  char xx=(char)sort[j];
			sss=sss+xx;
		  }
		  
		  System.out.println(sss);
		  sss="";
      }
      
    }
    
    public static int[] heapsort(int[] num) 
    {
        constructHeap(num);
        
       
        
        int end = num.length-1;
        while(end>0)
        {
            int temp = num[0];
            num[0] = num[end];
            num[end] = temp;
            bubbleDown(num,0,end-1);
            end--;
        }
          
       return num;
    }
    
    public static void constructHeap(int[] num)
    {
        int start = (num.length/2)-1;
        int end = num.length-1;
        
        while(start>=0)
        {
            bubbleDown(num,start, end);
            
            if(start==0)
                break;
            
            start= start-1;            
        }
    }
    
    public static void bubbleDown(int[] num, int start, int end)
    {   
        int root = start;
        while(root*2+1<=end)
        { 
            int swap = root;
            int child = root*2+1;
            int rchild = root*2+2;
            
            if(num[swap]>num[child])
            {
                swap = child;
            }
            
            if(rchild<=end && num[swap]>num[rchild])
            {
                swap = rchild;
            }
            
            if(swap!=root)
            {
                int temp = num[root];
                num[root] = num[swap];
                num[swap] = temp;
                
                root = swap;
            }
            else
                return;
            
        }
    }
    
}
