public class Queue
{	
	int [] arr;
	int length;
	int rear;
	int front;
	public Queue(int e)
	{
		arr= new int[e];
		length = 0;
			
	}
	public int len()
	{
		return length;
	}
	public boolean isEmpty()
	{
		if(length==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int first()
	{
		if (isEmpty()) 
		{
			return 0;	
		}
		else
		{
			return arr[front];
		}

	}
	public void enqueue(int e)
	{
		if (isEmpty()) 
		{
			arr[0]=e;	
		}
		else
		{
			arr[rear+1]=e;
			rear++;
		}
		length = length+1;
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			front =front+1;
			length = length -1;

		}
		return arr[front-1];
	}

	public static void main(String[] args) 
	{
		Queue obj = new Queue(5);
		obj.enqueue(1);
		obj.enqueue(5);		
		obj.enqueue(2);
		obj.enqueue(3);
		// obj.dequeue();
		// obj.isEmpty();
		// obj.first();
		System.out.println("The length of the Queue is: " + obj.len());
		System.out.println("The Queue is Empty: " + obj.isEmpty());
		System.out.println("The dequeued element is: " +obj.dequeue());
		System.out.println("The first element in Queue is: "+ obj.first());


	}
}