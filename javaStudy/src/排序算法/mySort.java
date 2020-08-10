package ≈≈–ÚÀ„∑®;


import java.util.Arrays;

public class mySort {

	public static int binarySearch(int arr[],int value) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int high=arr.length-1,mid=0,low=0;
		while(low<high) {
			mid=(low+high)/2;
			if(value==arr[mid])
				return mid+1;
			else if(value<arr[mid])
				high=mid-1;
			else if(value>arr[mid])
				low=mid+1;
			System.out.println(mid);
		}
		return -1;
		
	}
	public static void mpSort(int arr[]) {
		
		for(int i=0;i<arr.length-1;i++) {
			boolean flag=true;
			for(int j=0;j<arr.length-1-i;j++) {
				int temp=0;
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=false;
					System.out.println(Arrays.toString(arr));
					System.out.println("########");
				}
			}
			if(flag) {System.out.println(Arrays.toString(arr));break;}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,5,6,8,2,4,9,7};
//		System.out.println(binarySearch(arr, 5));
		mpSort(arr);
		
	}

}
