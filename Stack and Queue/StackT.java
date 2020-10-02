public class StackT
{	
	int max=10;
	int []arr=new int[max];
	int size=0;
	int top;//Top is indexes top=-1

	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		if (size==0) 
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	public int top()
	{
		if (top==0) 
		{
			return 0;
			
		}
		else
		{
			return arr[top];

		}
		
	}

	public void push(int e)
	{
		if(top>max)
		{

			System.out.println("StackOverflowError");
		}
		else
		{
			arr[++top]=e;
			System.out.println( e);
		}

		size=size+1;

	}

	public void pop()
	{
		if(top==0)
		{
			System.out.println("StackUnderflowError");
		}
		else
		{
			int e =arr[top--];
			System.out.println("Poped :" + e);
		}
		size=size-1;
	}
	public static void main(String[] args) 
	{
		StackT obj = new StackT();
		obj.push(1);
		obj.push(3);
		obj.push(7);
		obj.push(0);

		obj.pop();
		// obj.size();
		// obj.isEmpty();
		// obj.top();

		System.out.println("The size of the stack is: "+obj.size());
		System.out.println("The stack is Empty: "+obj.isEmpty());
		System.out.println("The top value is: "+obj.top());

	}
}