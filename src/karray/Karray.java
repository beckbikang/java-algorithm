package karray;

import javax.sound.midi.Soundbank;

public class Karray {

	public static void main(String[] args) {
		System.out.println("tt");
		
	}
}


class HighArray{
	
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
	
}
