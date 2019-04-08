package buldingBlocks;

public class Arrays {
	public static void printAllArray(int[] arr) {
		for(int i=1;i<=arr.length;i++) {
			System.out.print(arr[i-1]+" ");
		}
		System.out.println();
	}
	
	//Inserting a value at a particular position
	
	public static int[] moveElementInternally(int[] arr,int startIndex,int targetIndex) {
		//Element to be moved is at index startIndex
		//Where to move the elemnt at index targetIndex
		int startValue=arr[startIndex];
		if(startIndex==targetIndex) {
			return arr;
		}
		else if(startIndex < targetIndex){
		for(int i=startIndex;i<=targetIndex;i++) {
			arr[i]=arr[i+1];
			}
		arr[targetIndex]=startValue;
	}
		else if(startIndex > targetIndex){
		for(int i=startIndex;i>=targetIndex;i--) {
			arr[i+1]=arr[i];
		}
		arr[targetIndex]=startValue;
	}
		return arr;
}



	//Inserting a new Elemnt at a particular position
	public static int[] appendNewElemnt(int[] arr,int value,int position) {
		if(position==arr.length) {
			arr[arr.length]=value;
			return arr;
		}
		else {
			for(int i=position;i<=arr.length;i++) {
			arr[position+1]=arr[position];
			}
			arr[position]=value;
			return arr;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.print("Array:");
		int[] elements= {1,12,14,18,19,19,22,55,100,47};
		printAllArray(elements);
		
		System.out.print("Position Interchanged:");
		moveElementInternally(elements,2,5);
		printAllArray(elements);
		
		System.out.print("New Elemnt Added:");
		elements=appendNewElemnt(elements, -20,5);
		printAllArray(elements);
	}


}