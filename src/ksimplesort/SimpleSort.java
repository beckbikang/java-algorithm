package ksimplesort;

import javax.sound.midi.Soundbank;

public class SimpleSort {
	
	public static void main(String[] args) {
		System.out.println("start simple sort");
		//tbubsort();
		tselectsort();
	}
	
	public static void tselectsort() {
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
		arrayBub.bubsort();
		arrayBub.display();
	}
	
	public static void tbubsort() {
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
		arrayBub.bubsort();
		arrayBub.display();
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
		
		private void swap(int one, int two){
			long tmp = arr[one];
			arr[one] = arr[two];
			arr[two] = tmp;
		}
		
	
}