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

	public static String largestRowOrColumn(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		
		//Here we have number of rows and columns
		
		int rowsSum[] = new int[rows];
		for(int i=0; i<rows; i++) {
			int sum = 0;
			for(int j=0; j<cols; j++) {
				sum += arr[i][j];
			}
			rowsSum[i] = sum;  //The sum will be added to a index corresponding to the index of the row that is being iterated
		}  
		
		int colsSum[] = new int[cols];
		for(int j=0; j<cols; j++) {
			int sum = 0;
			for(int i=0; i<rows; i++) {
				sum += arr[i][j];
			}
			colsSum[j] = sum;   //The sum will be added to a index corresponding to the index of the column that is being iterated
		}
		
		//Now we have the row sum and column sum in two arrays rowsSum[] & colsSum[]
		
		int rowMax = rowsSum[0];
		int indexOfMaxSumRow = 0;
		for(int i=0; i<rowsSum.length; i++) {
			if(rowsSum[i] > rowMax) {
				rowMax = rowsSum[i];
				indexOfMaxSumRow = i;
			}
		}
		
		int colMax = colsSum[0];
		int indexOfMaxSumCol = 0;
		for(int i=0; i<colsSum.length; i++) {
			if(colsSum[i] > colMax) {
				colMax = colsSum[i];
				indexOfMaxSumCol = i;
			}
		}
		
		//We have the maximum sum row and maximum sum cols with both of their indices
		
		if(rowMax == colMax) {
//			System.out.println("row " + indexOfMaxSumRow + " " + rowMax);   //If row sum and column sum is equal then row sum is given priority
			String answer = "row " + Integer.toString(indexOfMaxSumRow) + " " + Integer.toString(rowMax);
			return answer;
		}
		
		if(rowMax > colMax) {
			String answer = "row " + Integer.toString(indexOfMaxSumRow) + " " + Integer.toString(rowMax);
			return answer;
		} else {
			String answer = "column " + Integer.toString(indexOfMaxSumCol) + " " + Integer.toString(colMax);
			return answer;
		}
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
//		int rows = arr.length;
//		int cols = arr[0].length;
//		boolean[][] isVisited = new boolean[rows][cols];
//		int[] ans = new int[rows*cols];
//		int index = 0;
//		
//		for(int k=0; k<rows; k++) {
//			
//			for(int j=k, i=k; j<cols-k; j++) {
//				if(isVisited[i][j] == true) return ans;
//				else isVisited[i][j] = true;
//				ans[index++] = arr[i][j];
//			}
//			
//			for(int i=k, j=cols-1-k; i<rows-k; i++) {
//				if(isVisited[i][j] == true) return ans;
//				else isVisited[i][j] = true;
//				ans[index++] = arr[i][j];
//			}
//			
//			for(int j=cols-1-k, i=rows-1-k; j>=k; j--) {
//				if(isVisited[i][j] == true) return ans;
//				else isVisited[i][j] = true;
//				ans[index++] = arr[i][j];
//			}
//			
//			for(int i=rows-1-k, j=k; i>=k; i--) {
//				if(isVisited[i][j] == true) return ans;
//				else isVisited[i][j] = true;
//				ans[index++] = arr[i][j];
//			}
//		}
//		return ans;
		
		int top = 0, down = arr.length-1, left = 0, right = arr[0].length-1;
		int dir = 0;
		int ans[] = new int[(arr.length)*(arr[0].length)];
		int index = 0;
		
		while(top<=down && left<=right) {
			if(dir==0) {
				for(int i=left; i<=right; i++) {
					ans[index++] = arr[top][i];
				}
				top++;
			} else if(dir==1) {
				for(int i=top; i<=down; i++) {
					ans[index++] = arr[i][right];
				}
				right--;
			} else if(dir==2) {
				for(int i=right; i>=left; i--) {
					ans[index++] = arr[down][i];
				}
				down--;
			} else if(dir==3) {
				for(int i=down; i>=top; i--) {
					ans[index++] = arr[i][left];
				}
				left++;
			}
			
			dir = (dir+1)%4;
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
		
	}
}
