package codingNinjas;

import java.util.*;

public class SearchingAndSortingAlgirithms {
	
	public static int binarySearch(int[] arr, int x) {
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr.length-1;
		
		while(start<=end) {
			int mid = (start+end)/2;
			int temp = arr[mid];
			if(temp==x) return mid;
			else if(temp>x) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static void takeInput(int[] arr) {
		Scanner sc = new Scanner(System.in);
		int n = arr.length;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int min = arr[i];
			int minIndex = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j]<min) {
					min = arr[j];
					minIndex = j;
				}
			}
			if(minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-(i+1); j++) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=1; i<n; i++) {
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static int[] mergeTwoSortedArraysAndReturnANewSortedMergedArray(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		
		int[] ans = new int[n+m];
		int index = 0;
		
		int i=0;  //Pointer for arr1
		int j=0;  //Pointer for arr2
		
//		while(i<n || j<m) {
//			if((arr1[i]<arr2[j]) && (i<n && j<m)) ans[index++] = arr1[i++];
//			else if((arr1[i]>arr2[j]) && (i<n && j<m)) ans[index++] = arr2[j++];
//			else if(i>=n) ans[index++] = arr2[j++];
//			else ans[index++] = arr1[i++];
//		}
		
		while(i<n && j<m) {
			if(arr1[i]<arr2[j]) ans[index++] = arr1[i++];
			else ans[index++] = arr2[j++];
		}
		
		while(i<n) {
			ans[index++] = arr1[i++];
		}
		
		while(j<m) {
			ans[index++] = arr2[j++];
		}
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] ans = new int[t][];
		int index = 0;
		
		while(t-->0) {
			int n = sc.nextInt();
			int[] arr1 = new int[n];
			takeInput(arr1);
			int m = sc.nextInt();
			int[] arr2 = new int[m];
			takeInput(arr2);
			int[] temp = mergeTwoSortedArraysAndReturnANewSortedMergedArray(arr1, arr2);
			ans[index++] = temp;
		}
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
