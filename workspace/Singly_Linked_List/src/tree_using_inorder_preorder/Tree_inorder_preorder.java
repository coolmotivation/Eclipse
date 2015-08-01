package tree_using_inorder_preorder;
import java.util.Scanner;
import java.util.Vector;

public class Tree_inorder_preorder {
	static Vector<Integer> inorder=new Vector<Integer>();
	static Vector<Integer> preorder=new Vector<Integer>();
	static int preIndex=0;
	
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Please enter number of nodes::");
			int n=Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter the inorder sequence::");
			int h=0;
			while(h != n)													//4 10 3 1 7 11 8 2
			{																//7 10 4 3 1 2 8 11
			 inorder.add(sc.nextInt());	
			 h++;
			}
			
			System.out.println("Enter the preorder sequence::");
			h=0;
			while(h != n)
			{
			 preorder.add(sc.nextInt());	
			 h++;
			}
			Node root=build_tree(inorder,preorder,0,inorder.size()-1);
			printInorder(root);
			System.out.println(" ");
			printPreorder(root);
		}
		public static void printPreorder(Node temp)
		{
			if(temp!=null)
			{
				System.out.printf("%d ",temp.getData());
				printPreorder(temp.getLeft());
				printPreorder(temp.getRight());
			}
		}
		public static void printInorder(Node root)
		{
			if(root!=null)
			{
				printInorder(root.getLeft());
				System.out.printf("%d ",root.getData());
				printInorder(root.getRight());
			}
		}
		public static Node build_tree(Vector inorder,Vector preorder,int instart,int inend)
		{
			if(instart > inend)
				return null;
			
			Node tNode=new Node((Integer) preorder.elementAt(preIndex));
			preIndex++;
			
			if(instart == inend)
				return tNode;
			
			int inIndex=search(inorder,instart,inend,tNode.getData());
			
			tNode.setLeft(build_tree(inorder,preorder,instart,inIndex-1));
			tNode.setRight(build_tree(inorder,preorder,inIndex+1,inend));
			
			
			return tNode;
		}
		public static int search(Vector in,int start,int end,int data)
		{
			int i;
			for(i=start;i<=end;i++)
			{
				if((Integer)in.elementAt(i) == data)
					return i;
			}
			return 0;
		}
}
