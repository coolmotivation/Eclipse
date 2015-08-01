package three_sum_problem;

import java.util.*;

public class Three_Sum_Problem {
	
	static List<Integer> first=new LinkedList<Integer>();
	static List<Integer> second=new LinkedList<Integer>();
	static List<Integer> third=new LinkedList<Integer>();
	
	public static void main(String args[])
		{
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of elements in the first,second,third list");
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			int n3=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<n1;i++)
			{
				first.add(sc.nextInt());
			}
			sc.nextLine();
			for(int i=0;i<n2;i++)
			{
				second.add(sc.nextInt());
			}
			sc.nextLine();
			for(int i=0;i<n3;i++)
			{
				third.add(sc.nextInt());
			}
			sc.nextLine();
			Collections.sort(second);
			Collections.sort(third);
			Collections.reverse(third);
			System.out.println("Enter the final number::");
			find_triplet(Integer.parseInt(sc.nextLine()));
			sc.close();
		}
	public static void find_triplet(int addnumber)
	{
	     int fcn=0;
		while(fcn < first.size())
		{
			int scn=0;
			int tcn=0;
			
			while( scn<second.size() && tcn < third.size())
			{
				int add=first.get(fcn) + second.get(scn) + third.get(tcn);
				if(add == addnumber)
				{
					System.out.println(+first.get(fcn) + "  " +second.get(scn)+ "  " +third.get(tcn));
					return;
				}
				else if(add < addnumber)
					scn++;
				else if(add > addnumber)
					tcn++;
					
			}
			fcn++;
		}
	}
}
