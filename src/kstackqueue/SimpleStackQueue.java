package kstackqueue;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingUse;

public class SimpleStackQueue {

	public static void main(String args[]) {
		//tstack();
		//tqueue();
		tqueue2();
	}
	public static void tqueue2() {
		Queue queueS = new Queue(5);
		queueS.insert(1);
		queueS.insert(2);
		queueS.insert(3);
		queueS.insert(4);
		queueS.insert(5);
		queueS.insert(6);
		System.out.println("size="+queueS.size());
		while (!queueS.isEmpty()) {
			long val = queueS.remove();
			System.out.print(val);
			System.out.println(" ");
		}
		System.out.println("size="+queueS.size());
		
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
 * front 指向当前有数据的待取出数据的位置。
 * rear 指向当前为数据的待插入的数据
 * 
 * 实际上rear代表的就是始终未利用存储数据的那个空间。
 * 分配size的空间实际使用了size-1条数据
 * 
 *  empty 如果rear和front都指向那个空的空间，代表就是空
 *  如果rear的下一个数据就是front代表队列已满
 * 
 * 
 * 
 * 满了就不插入的队列
 */

class Queue{
	
	private int max;
	private long[] queArr;
	
	private int front;
	private int rear;
	
	/**
	 * 多一条数据,实际存储数据为s
	 * 
	 * @param s
	 */
	public Queue(int s){
		max = s + 1;
		queArr = new long[max];
		front = 0;
		rear = 0;
	}
	
	//尾部插入,插入
	public boolean insert(long j){
		//如果已经满了，不允许插入
		if(isFull()) {
			System.out.println("queue is full");
			return false;
		}
		
		queArr[rear] = j;
		rear = (rear+1)%max;
		return true;
	}
	
	//移除, front 始终是非负数
	public long remove(){
		long temp = queArr[front];
		front = (front+1)%max;
		return temp;
	}
	
	public long peek(){
		return queArr[front];
	}
	
	//相等即为空，因为满了不再让放入数据
	public boolean isEmpty(){
		return rear == front;
	}
	
	//
	public boolean isFull(){
		return (rear+1)%max == front;
	}
	
	public int size(){
		return (rear-front+max)%max;
	}
	
}




