package codingNinjas;
import java.util.*;
public class TwoDimensionalArray {

	public static int[] rowWiseSum(int[][] arr) {
		int rows = arr.length;
		int[] ans = new int[rows];
		int index = 0;
		for(int i=0; i<rows; i++) {
			int sum = 0;
			for(int j=0; j<arr[i].length; j++) {
				sum += arr[i][j];
			}
			ans[index++] = sum;
		}
		return ans;
	}
	
	public static int[][] takeInput() {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int arr[][] = new int[rows][cols];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		return arr;
	}
	
	public static void printTwoDimensionalArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[] largestRowOrColumn(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		int[] ans = new int[4];
		ans[0] = Integer.MIN_VALUE;  //Row sum
		ans[2] = Integer.MIN_VALUE;   //col sum
		ans[1] = -1; //rowIndex
		ans[3] = -1; //colIndex
		
		for(int i=0; i<rows; i++) {
			int rowSum = 0;
			for(int j=0; j<cols; j++) {
				rowSum += arr[i][j];
			}
			if(rowSum > ans[0]) {
				ans[0] = rowSum;
				ans[1] = i;
			}
		}
		
		for(int i=0; i<cols; i++) {
			int colSum = 0;
			for(int j=0; j<rows; j++) {
				colSum += arr[j][i];
			}
			if(colSum > ans[2]) {
				ans[2] = colSum;
				ans[3] = i;
			}
		}
		
		return ans;
		
	}

	public static int[] printLikeAWave(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		int[] ans = new int[rows*cols];  //Total number of elements in the array will be rows*cols
		int index = 0;
		
		
		for(int j=0; j<cols; j++) {
			if(j%2==0) {    //If the column is even then top to bottom is printed
				for(int i=0; i<rows; i++) {
					ans[index++] = arr[i][j];
				}
			} else {        //If the column is odd then bottom to top is printed
				for(int i=rows-1; i>=0; i--) {
					ans[index++] = arr[i][j];
				}
			}
		}
		
		return ans;
	}
	
	public static int[] printSpiral(int[][] arr) {
		int rows = arr.length, cols = arr[0].length;
		int[] ans = new int[rows*cols];
		int index = 0;
		
		int top = 0, down = rows-1, left = 0, right = cols-1;
		int i = 0;
		
		while(top<=down && left<=right) {
			if(i==0) {
				for(int j=left; j<=right; j++) {
					ans[index++] = arr[top][j];
				}
				top++;
				i++;
				i = i%4;
			} else if(i==1) {
				for(int j=top; j<=down; j++) {
					ans[index++] = arr[j][right];
				}
				right--;
				i++;
				i = i%4;
			} else if(i==2) {
				for(int j=right; j>=left; j--) {
					ans[index++] = arr[down][j];
				}
				down--;
				i++;
				i = i%4;
			} else {
				for(int j=down; j>=top; j--) {
					ans[index++] = arr[j][left];
				}
				left++;
				i++;
				i=i%4;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[][] answer = new int[t][];
		int index = 0;
		
		while(t-->0) {
			int arr[][] = takeInput();
			answer[index++] = printSpiral(arr);
		}
		
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[i].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
