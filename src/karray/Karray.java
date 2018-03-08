package karray;

import javax.sound.midi.Soundbank;

public class Karray {

	public static void main(String[] args) {
		System.out.println("tt");
		tlowArray();
		tHightArray();
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
	
	
}


//a more complex version

class OrderArray{
	
	private long[] arr;
	private int nElems;
	
	public OrderArray(int max){
		
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
