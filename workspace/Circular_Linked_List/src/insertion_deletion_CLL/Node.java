package insertion_deletion_CLL;

public class Node {
		private Node next;
		private Integer data;
		public Node()
		{
			this.data=null;
			this.next=null;
		}
		public void setData(Integer data)
		{
			this.data=data;
		}
		public Integer getData()
		{
			return this.data;
		}
		public void setNext(Node temp)
		{
			this.next=temp;
		}
		public Node getNext()
		{
			return this.next;
		}
}
