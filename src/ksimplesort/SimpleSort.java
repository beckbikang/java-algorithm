package ksimplesort;

import javax.sound.midi.Soundbank;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class SimpleSort {


	public static final String FORMAT_FLOAT_STR = ",###,##0.00";
	
	public static void main(String[] args) {
		System.out.println("start simple sort");
		//tbubsort();
		//tselectsort();
		//tinsertsort();
		//tobjectsort();
		tformat();
	}

	//基本的格式化
	public static void tformat(){
		float doNumber = 12.0f;

		DecimalFormat df = new DecimalFormat(FORMAT_FLOAT_STR);
		String ret = df.format(doNumber);
		System.out.println(ret);

		Map<String, String> mapData = new HashMap<>();
		if(mapData == null){
			System.out.println("mapData is null");
		}else{
			System.out.println("mapData is not null");
		}

	}


	public static void tobjectsort(){
		ClassArray classArray = new ClassArray(100);
		classArray.insert("aim", "as", 11);
		classArray.insert("tom", "ca", 12);
		classArray.insert("sim", "ba", 13);
		classArray.insert("aim2", "td", 14);
		classArray.insert("kim", "ka", 15);
		classArray.insert("dd","a1", 31);
		classArray.display();
		classArray.insertSort();
		classArray.display();
	}
	
	public static void tinsertsort() {
		ArrayBub arrayBub = getArrayBub();
		arrayBub.insertSort();
		arrayBub.display();
	}
	
	public static void tselectsort() {
		ArrayBub arrayBub = getArrayBub();
		arrayBub.bubsort();
		arrayBub.display();
	}
	
	public static void tbubsort() {
		ArrayBub arrayBub = getArrayBub();
		arrayBub.bubsort();
		arrayBub.display();
	}
	
	public static ArrayBub getArrayBub() {
		ArrayBub arrayBub = new ArrayBub(1000);
		arrayBub.insert(1312);
		arrayBub.insert(13);
		arrayBub.insert(8);
		arrayBub.insert(5);
		arrayBub.insert(4);
		arrayBub.insert(32);
		arrayBub.insert(12);
		arrayBub.insert(11);
		arrayBub.display();
		return arrayBub;
	}
}


class ArrayBub{
		private long[]arr;
		private int size;
		private int max ;
	
		
		public ArrayBub(int max){
			arr = new long[max];
			size = 0;
			this.max = max;
		}
		
		public boolean insert(long value){
			if(size == max){
				return false;
			}
			arr[size] = value;
			size++;
			return true;
		}
		
		public void display(){
			System.out.println("##############");
			for(int i=0; i < size; i++){
				System.out.println(arr[i]+" ");
			}
			System.out.println("##############");
		}
		
		/**
		 * 冒泡排序
		 * 
		 * 说明:
		 * 	  稳定排序
		 * 	  算法复杂度N*N
		 * 
		 */
		public void bubsort(){
			int i,j;
			//从最后一个元素开始，一直到第二个元素
			for (i = size-1; i > 1; i--) {//out loop
				//最第一个元素，一直到i-1个元素
				for(j = 0; j < i;j++){//int loop
					if(arr[j] > arr[j+1]){//比较
						swap(j, j+1);//swap
					}
				}
			}
		}
		
		/**
		 * 选择排序
		 * 		1 稳定排序
		 *      2 N*N
		 * 
		 * 
		 */
		public void selectSort(){
			int i,j,min;
			for (i = 0; i < size - 1; i++) {//out
				min = i;
				for(j = i+1; j < size;j++){//in
					if(arr[j] < arr[min]){//compare
						min = j;
					}
				}
				swap(min, i);//swap
			}	
		}
		
		/*
		 * 
		 * 插入排序
		 * 		1 稳定排序
		 *      2 N*N
		 *
		 */
		public void insertSort(){
			int i,j;
			for(i=1; i < size; i++){
				long temp = arr[i];
				j = i;
				while(j > 0 && arr[j-1] > temp){
					arr[j] = arr[j-1];
					j--;
				}
				arr[j] = temp;
			}
		}
		
		private void swap(int one, int two){
			long tmp = arr[one];
			arr[one] = arr[two];
			arr[two] = tmp;
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
	
	public void insertSort(){
		int i,j;
		for(i=1; i < used; i++){
			Person temp = arr[i];
			j = i;
			while(j > 0 && arr[j-1].getLastName().compareTo(temp.getLastName()) > 0){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
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
