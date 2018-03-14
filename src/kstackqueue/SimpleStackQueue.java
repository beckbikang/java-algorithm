package kstackqueue;

public class SimpleStackQueue {

	public static void main(String args[]) {
		tstack();
	}
	
	//test stack
	public static void tstack() {
		StackX stackX = new StackX(1000);
		stackX.push(1);
		stackX.push(10);
		stackX.push(100);
		stackX.push(1000);
		
		while (!stackX.isEmpty()) {
			long val = stackX.pop();
			System.out.print(val);
			System.out.println(" ");
		}
		System.out.println("");
		
		
	}
}

class StackX{
	
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public StackX(int s){
		maxSize  = s;
		stackArray = new long[s];
		top = -1;
	}
	
	public void push(long l){
		stackArray[++top] = l;
	}
	
	public long pop(){
		return stackArray[top--];
	}
	
	public long peak(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == (maxSize -1);
	}
}
