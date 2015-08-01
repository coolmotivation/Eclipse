package tree_traversal;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class BST {
	static Node root=new Node();
	static int n;
	
	static int[] dep=new int[n];
	static int cn=0;
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of elements::");
			n=Integer.parseInt(sc.nextLine());
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				insertion(arr[i]);
			}
			/*postorder_recursively(root);
			System.out.println(" ");
			postorder_iteratively(root);*/
			//levelorder(root);
			//levelorder_iteratively(root);
			//inorder_without_recursion_without_stack(root);
			//inorder_morris_traversal(root);
			//preorder_iteration_geeks_for_geeks_using_stack(root);
			preorder_morris_traversal(root);
		}
		public static void insertion(int key)
	    {    int max_depth=0;
	    	if(root.getData() == null)
	    	{
	    		root.setData(key);
	    		max_depth++;
	    	}
	    	else
	    	{
	    		Node temp=root;
	    		Node x=null;
	    		while(temp != null)
	    		{
	    			x=temp;
	    			max_depth++;
	    			if(key < temp.getData())
	    				temp=temp.getLeft();
	    			else
	    				temp=temp.getRight();
	    		}
	    	    max_depth++;
	    		//x is the parent of the newNode
	    		Node newNode =new Node();
	    		newNode.setData(key);
	    		newNode.setParent(x);
	    		if(key < x.getData())
	    			x.setLeft(newNode);
	    		else
	    			x.setRight(newNode);
	    	}
	    	//dep[cn]=max_depth;
	    	//System.out.printf("%d ",dep[cn]);
	    	cn++;
	    }
		public static void inorder_recursively(Node temp)
		{
			if(temp!=null)
			{
				inorder_recursively(temp.getLeft());
				System.out.printf("%d ",temp.getData());
				inorder_recursively(temp.getRight());
			}
		}
		public static void preorder_recursively(Node temp)
		{
			if(temp!=null)
			{
				System.out.printf("%d ",temp.getData());
				preorder_recursively(temp.getLeft());
				preorder_recursively(temp.getRight());
			}
		}
		public static void postorder_recursively(Node temp)
		{
			if(temp!=null)
			{
				postorder_recursively(temp.getLeft());
				postorder_recursively(temp.getRight());
				System.out.printf("%d ",temp.getData());
			} 
		}
		public static void inorder_iteratively(Node temp)
		{
			int cn=0;
			Node popped=null;
			Stack<Node> s=new Stack<Node>();
			while(cn != n)
			{
				while(temp!=null)
				{
					s.push(temp);
					temp=temp.getLeft();
				}
				if(!s.empty())
				{  
					popped=s.pop();
					System.out.printf("%d ",popped.getData());
					cn++;
				}
				else
					break;
				
				while(popped.getRight()==null)
				{   if(!s.empty())
				    {
						popped=s.pop();
						System.out.printf("%d ",popped.getData());
						cn++;
				    }
				else
					break;
				}//loop stops only if the right Node of popped is not null
				if(cn==n)
					break;
				
				if(popped.getRight()!=null)
					temp=popped.getRight();
				
			}
			System.out.println(" ");
		}
		public static void preorder_iteratively(Node temp)
		{
			int cn=0;
			Node popped=null;
			Stack<Node> s=new Stack<Node>();
			while(cn != n)
			{
				while(temp!=null)
				{
					s.push(temp);
					System.out.printf("%d ",temp.getData());
					cn++;
					temp=temp.getLeft();
				}
				if(!s.empty())
				{  
					popped=s.pop();
				}
				else
					break;
				
				while(popped.getRight()==null)
				{   if(!s.empty())
				    {
						popped=s.pop();
				    }
				else
					break;
				}//loop stops only if the right Node of popped is not null
				if(cn==n)
					break;
				
				if(popped.getRight()!=null)
					temp=popped.getRight();
				
			}
			System.out.println(" ");
		}
//Preorder algorithm as on geeksforgeeks
		
		public static void preorder_iteration_geeks_for_geeks_using_stack(Node temp)
		{
			Stack<Node> s1=new Stack<Node>();
			s1.push(root);
			while(!s1.empty())
			{
				Node r=s1.pop();
				System.out.printf("%d ",r.getData());
				if(r.getRight()!=null)
					s1.push(r.getRight());
				if(r.getLeft()!=null)
					s1.push(r.getLeft());
			}
		}
		
//morris traversal for preorder traversal
		public static void  preorder_morris_traversal(Node temp)
		{
			Node current=temp;
			while(current!=null)
			{  
				System.out.printf("%d ",current.getData());
			
				if(current.getLeft()==null)
				{
					current=current.getRight();
				}
				else
				{
					Node pre=current.getLeft();
					while(pre.getRight()!=null)
					{
						pre=pre.getRight();
					}
					pre.setRight(current.getRight());
					current=current.getLeft();
				}
			}
		}
		public static void postorder_iteratively(Node temp)
		{
			int cn=0;
			Node peeked=null;
			Node popped=null;
			Stack<Node> s=new Stack<Node>();
			while(cn != n)
			{
				while(temp!=null)
				{
					s.push(temp);
					temp=temp.getLeft();
				}
				if(!s.empty())
				{  
					peeked=s.peek();
				}
				else
					break;
				
				while(peeked.getRight()==null)
				{   if(!s.empty())
				    {   
					   popped=s.pop();
					System.out.printf("%d ",popped.getData());
				        cn++;
				        if(popped.getParent()!=null)
				        {
				        		if((popped.getParent()).getLeft()==popped)
				        			(popped.getParent()).setLeft(null);
				        		else
				        			(popped.getParent()).setRight(null);
				        }
				        	popped=null;
				        if(!s.empty())
				        	peeked=s.peek();
				        else
				        	break;
				    }
				else
					break;
				}//loop stops only if the right Node of popped is not null
				if(cn==n)
					break;
				
				if(peeked.getRight()!=null)
					temp=peeked.getRight();
				
			}
			System.out.println(" ");
		}
		public static void levelorder(Node temp)
		{   
			Queue<Node> q=new LinkedList<Node>();
			q.add(temp);
			while(q.size()!=0)
			{
			 Node r=q.remove();
			 System.out.printf("%d ",r.getData());
			 if(r.getLeft()!=null)
				 q.add(r.getLeft());
			 if(r.getRight()!=null)
				 q.add(r.getRight());
			}
		}  
		public static int depth=0;
		public static int depth(Node temp)
		{
			if(temp==root)
				return 1;
			else
			{
				depth=depth(temp.getParent())+1;
				return depth;
			}
		}
		public static void levelorder_iteratively(Node temp)
		{
			int max=dep[0];
			for(int i=1;i<n;i++)
			{
				if(max<dep[i])
					max=dep[i];
			}
			// max is the maximum depth
			for(int i=1;i<=max;i++)
				printGivenLevel(root,i);
		}
		public static void printGivenLevel(Node temp,int depth)
		{
			if(depth==1)
				System.out.printf("%d ",temp.getData());
			else if(depth>1)
			{
				if(temp.getLeft()!=null)
						printGivenLevel(temp.getLeft(),depth-1);
				if(temp.getRight()!=null)
						printGivenLevel(temp.getRight(),depth-1);
			}
		}
		public static void inorder_without_recursion_without_stack(Node temp)//it's not the morris traversal
		{
		       int count=0;
		       while(count!=n)
		       {
		    	   while(temp.getLeft()!=null)
		    	   {
		    		   temp=temp.getLeft();
		    	   }
		    	   if(temp.getColor()!="Black")
		    	   {
		    		   System.out.printf("%d ",temp.getData());
		    		   temp.setColor("Black");
		    		   count++;
		    		   if(count==n)
		    			   break;
		    	   }
		    	   
		    	   if(temp.getRight()!=null)
		    		   temp=temp.getRight();
		    	   else
		    	   {
		    		   while(temp.getRight()==null)
		    		   { 
		    			   temp=temp.getParent();
		    			   
		    			   while(temp.getColor()!="White")
	    					     temp=temp.getParent();
		    			   if(temp.getColor()=="White")
		    			   {
		    				   System.out.printf("%d ",temp.getData());
		    				   count++;
		    				   if(count==n)
		    					   break;
		    				   temp.setColor("Black");
		    			   }
		    			   if(count==n)
		    				   break;
		    		   }
		    		   if(temp.getRight()!=null)
		    		   {
		    			   temp=temp.getRight();
		    		   }
		    	   }
		       }
		}
		public static void inorder_morris_traversal(Node temp)
		{
			Node current=temp;
			while(current!=null)
			{
				if(current.getLeft()==null)
				{
					System.out.printf("%d ",current.getData());
					current=current.getRight();
				}
				else
				{
					Node pre=current.getLeft();
					while(pre.getRight()!=null && pre.getRight()!=current)
					{
						pre=pre.getRight();
					}
					if(pre.getRight()==null)
						{pre.setRight(current);
						current=current.getLeft();
						}
					else   //will make sure that the tree is not reverted.
					{
						pre.setRight(null);
						System.out.printf("%d ",current.getData());
						current=current.getRight();
					}
				}
			}
		}
}
