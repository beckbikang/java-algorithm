package kstackqueue;

public class SimpleStackQueue {

	public static void main(String args[]) {
		//tstack();
		tqueue();
	}
	
	public static void tqueue() {
		QueueS queueS = new QueueS(100);
		queueS.insert(1);
		queueS.insert(2);
		queueS.insert(3);
		queueS.insert(4);
		queueS.insert(5);
		System.out.println("size="+queueS.size());
		while (!queueS.isEmpty()) {
			long val = queueS.remove();
			System.out.print(val);
			System.out.println(" ");
		}
		System.out.println("size="+queueS.size());
		
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


class QueueS{
	
	private int max;
	private long[] queArr;
	
	private int front;
	private int rear;
	private int size;
	
	/**
	 * 多一行数据，区分空和满
	 * 
	 * @param s
	 */
	public QueueS(int s){
		// 声明100。就可以存储到101
		max = s;
		size = 0;
		queArr = new long[max];
		front = 0;
		rear = -1;
	}
	
	//插入
	public void insert(long j){
		if(rear == max -1){//最后一个元素
			rear = -1;
		}
		queArr[++rear] = j;
		size++;
	}
	
	//移除
	public long remove(){
		long temp = queArr[front++];
		if(front == max){
			front = 0;
		}
		size--;
		return temp;
	}
	
	public long peek(){
		return queArr[front];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return size == max;
	}
	
	public int size(){
		return size;
	}
	
}


/**
 * 1 简单的方式在queue里面存一个size，通过size判断队列大小
 * 2 可以通过其他方式处理，提高性能，关键在于区分满和空
 * @author kang
 *
 */

class Queue{
	
	private int max;
	private long[] queArr;
	
	private int front;
	private int rear;
	
	/**
	 * 多一行数据，区分空和满
	 * 
	 * @param s
	 */
	public Queue(int s){
		max = s + 1;
		queArr = new long[max];
		front = 0;
		rear = -1;
	}
	
	//插入
	public void insert(long j){
		if(rear == max -1){//最后一个元素
			rear = -1;
		}
		queArr[++rear] = j;
	}
	
	//移除
	public long remove(){
		long temp = queArr[front++];
		if(front == max){
			front = 0;
		}
		return temp;
	}
	
	public long peek(){
		return queArr[front];
	}
	
	public boolean isEmpty(){
		//相隔一个
		//两种情况 1 front > rear 比如 1，0
		// 2 front < rear。 比如 0, 
		return (rear+1 == front) ||
				((front +max-1)%(max-1) == rear);
	}
	
	public boolean isFull(){
		return (rear+2 == front) ||
		(front+max-2 == rear);
	}
	
	public int size(){
		if(rear >= front){//尾部较大
			return rear-front+1;
		}else{//
			return ((max-front) +(rear+1))%(max-1);
		}
	}
	
	
	
	
}





