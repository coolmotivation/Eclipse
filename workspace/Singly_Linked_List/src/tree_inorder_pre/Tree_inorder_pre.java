package tree_inorder_pre;
import java.util.Scanner;

public class Tree_inorder_pre {
	   static int[] inorder;
	   static int[] preorder;
	   static int preIndex;
	public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of elements::");
			int n=Integer.parseInt(sc.nextLine());
			inorder=new int[n];
			preorder=new int[n];
			System.out.println("Enter the inorder sequence fast::");
			for(int i=0;i<n;i++)
			{
				inorder[i]=sc.nextInt();
			}
			System.out.println("Enter the preorder sequence fast::");
			for(int i=0;i<n;i++)
			{
				preorder[i]=sc.nextInt();
			}
			Node root=build_tree(0,n-1);     
			printInorder(root);
			System.out.println(" ");
			printPreorder(root);
		}
	public static void printInorder(Node temp)
	{
		if(temp!=null)
		{
			printInorder(temp.getLeft());
			System.out.printf("%d ",temp.getData());
			printInorder(temp.getRight());
		}
	}                                               //4 10 3 1 7 11 8 2         //7 10 4 3 1 2 8 11
	public static void printPreorder(Node temp)
	{
		if(temp!=null)
		{
			System.out.printf("%d ",temp.getData());
			printPreorder(temp.getLeft());
			printPreorder(temp.getRight());
		}
	}
	public static Node build_tree(int instart,int inend)
	{
		if(instart > inend)
			return null;
		
		Node tNode=new Node(preorder[preIndex]);
		preIndex++;
		
		if(instart == inend)
			return tNode;
		 
		int t=search(instart,inend,tNode.getData());
		
		tNode.setLeft(build_tree(instart,t-1));
		tNode.setRight(build_tree(t+1,inend));
	
		return tNode;
	}
	public static int search(int start,int end,int data)
	{
		int i;
		for(i=start;i<=end;i++)
		{
			if(inorder[i]==data)
				return i;
		}
		return 0;
	}
}
