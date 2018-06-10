package karray;

import javax.sound.midi.Soundbank;

public class Karray {

	public static void main(String[] args) {
		System.out.println("tt");
		tlowArray();
		tHightArray();
		tOrderArray();
		tClassArray();
	}
	
	
	
	public static void tlowArray(){
		LowArray lowArray = new LowArray(100);
		lowArray.setElem(0, 11);
		lowArray.setElem(1, 22);
		lowArray.setElem(2, 33);
		lowArray.setElem(3, 44);
		System.out.println(lowArray.arrSize());
	}
	
	public static void tHightArray(){
		HighArray highArray = new HighArray(100);
		highArray.insert(1);
		highArray.insert(2);
		highArray.insert(3);
		highArray.insert(4);
		highArray.insert(5);
		highArray.insert(6);
		highArray.insert(7);
		highArray.display();
		highArray.delete(3);
		highArray.display();
	}
	
	public static void tOrderArray() {
		OrderArray orderArray = new OrderArray(100);
		orderArray.insert(3);
		orderArray.insert(1);
		orderArray.insert(2);
		orderArray.insert(5);
		orderArray.insert(10);
		orderArray.insert(9);
	
		orderArray.display();
		
		orderArray.delete(3);
		orderArray.display();	
	}
	
	public static void tClassArray() {
		ClassArray classArray = new ClassArray(100);
		classArray.insert("aim", "as", 11);
		classArray.insert("tom", "ca", 12);
		classArray.insert("sim", "ba", 13);
		classArray.insert("tim", "td", 14);
		classArray.insert("kim", "ka", 15);
		classArray.display();
		classArray.insert("dd","a1", 31);
		classArray.display();
		classArray.delete("tom");
		classArray.display();
		
	}
}

class Person{
	private String firstName;
	private String lastName;
	
	private int age;
	
	public  Person(String l, String f, int a) {
		firstName = f;
		lastName = l;
		age = a;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void displayPerson() {
		System.out.print(" last name:"+lastName);
		System.out.print(",first name:"+firstName);
		System.out.println(", age:"+age);
	}
}

class ClassArray{
	private Person[] arr;
	private int used;
	
	public ClassArray(int max){
		arr = new Person[max];
		used = 0;
	}
	
	
	public Person find(String lname){
		int j;
		for(j=0; j < used; j++){
			if(arr[j].getLastName().equals(lname)) break;
		}
		if (j == used){
			return null;
		}else{
			return arr[j];
		}
	}
	
	public void insert(String l, String f, int age) {
		arr[used] = new Person(l, f, age);
		used++;
	}
	
	
	public boolean delete(String name) {
		int j;
		for(j=0; j<used; j++){
			if(arr[j].getLastName().equals(name)) break;
		}
		if(j == used){
			return true;
		}else{
			for(int k=j; k < used; k++){
				arr[k] = arr[k+1];
			}
			used--;
			return true;
		}
		
		
	}
	
	
	public void display() {
		System.out.println("###########");
		for(int i=0; i < used; i++){
			arr[i].displayPerson();
		}
		System.out.println("###########");
	}
	
}


//a more complex version
class OrderArray{
	
	private long[] arr;
	private int used;
	
	public OrderArray(int max){
		arr = new long[max];
		used = 0;
	}
	
	public int size() {
		return used;
	}
	
	public int find(long searchVal) {
		int left = 0;
		int right = used;
		int middle;
		
		while(true){
			middle = (left+right)/2;
			if(arr[middle] == searchVal) {
				return middle;
			}else if(left > right){
				return -1;
			}else{
				if(arr[middle] < searchVal){
					left = middle+1;
				}else{
					right = middle-1;
				}
			}
		}
	}
	
	//todo
	//未考虑溢出
	//not think about overflow array
	public void insert(long value) {

		int j;
		for(j =0; j < used; j++){
			if(arr[j] > value){
				break;
			}
		}
		//从j开始的元素往后移动
		for(int n=used; n > j; n--){
			arr[n] = arr[n-1];
		}
		arr[j] = value;
		used++;
	}

	public boolean delete(long value) {
		int i = find(value);
		if(i == used) {
			return false;
		}else {
			
			for(int j=i; j < used; j++){
				arr[j] = arr[j+1];
			}
			used--;
			return true;
		}
	}
	
	
	public void display() {
		int j;
		for(j = 0; j < used; j++){
			System.out.print(arr[j]+" ");
		}
		System.out.println("");
	}
	
}



//a simple version
class HighArray{
	private long[] arr;
	private int used;
	public  HighArray( int len) {
		arr = new long[len];
		used = 0; 
	}
	
	public boolean find(long key) {
		int j;
		for(j = 0; j < used; j++){
			if(arr[j] == key) break;
		}
		if(j == used) return false;	
		return true;
	}
	
	public int getSize() {
		return used;
	}
	
	public void insert(long value) {
		arr[used] = value;
		used++;
	}
	
	
	public boolean delete(long value){
		int i;
		
		for(i=0; i < used; i++){
			if(value == arr[i]){
				break;
			}
		}
		if(i == used){
			return false;
		}else{
			for(int k=i; k <used; k++){
				arr[k] = arr[k+1];
			}
			used--;
			return true;
		}
	}
	
	

	public void display() {
		int j;
		for(j = 0; j < used; j++){
			System.out.print(arr[j]+" ");
		}
		System.out.println("");
	}
	
	
}


//it has some error
class LowArray{
	private long[] arr;
	public  LowArray( int len) {
		arr = new long[len];
	}
	public void setElem(int index, int val){
		arr[index] = val;
	}
	public long getElem(int index){
		return arr[index];
	}
	public int arrSize() {
		return arr.length;
	}
	
}
