package laioffer;

import java.util.Random;

public class SortingAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array = {-9,2,4,1,6,5};
		//int[] result = mergeSort(array);
		int[] array = {0,1,-1,1,0,-1,0,1};
		int[] result = quickSort(array);
		for (int i:result) {
			System.out.print(i + ", ");
		}

	}
	
	
	public static int[] mergeSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int[] helper = new int[array.length];
		mergeSort(array, 0, array.length-1, helper);
		return array;
	}
	
	private static void mergeSort(int[] array, int left, int right, int[] helper) {
		if (left >= right) {
			return;
		}
		
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid, helper);
		mergeSort(array, mid+1, right, helper);
		merge(array, left, right, mid, helper);
	}
	
	private static void merge(int[] array, int left, int right, int mid, int[] helper) {
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		int leftIdx = left;
		int rightIdx = mid + 1;
		while (leftIdx <= mid && rightIdx <= right) {
			if (helper[leftIdx] <= helper[rightIdx]) {
				array[left++] = helper[leftIdx++];
			} else {
				array[left++] = helper[rightIdx++];
			}
		}
		
		while (leftIdx <= mid) {
			array[left++] = helper[leftIdx++];
		}
	}
	
	public static int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		quickSort(array, 0, array.length-1);
		return array;	
	}
	
	public static void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotIdx = partition(array, left, right);
		quickSort(array, left, pivotIdx-1);
		quickSort(array, pivotIdx+1, right);
	}
	
	private static int partition(int[] array, int left, int right) {
		Random rand = new Random();
		int pivotIdx = rand.nextInt(right-left+1)+left;
		int pivot = array[pivotIdx];
		swap(array, pivotIdx, right);
		int leftBound = left;
		int rightBound = right-1;
		while (leftBound <= rightBound) {
			if (array[leftBound] <= pivot) {
				leftBound++;
			} else if (array[rightBound] > pivot){
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		swap(array, leftBound, right);
		return leftBound;
		
	}
	
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static int[] rainbowSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int i = 0;
		int j = 0;
		int k = array.length-1;
		while (j <= k) {
			if (array[j] == 1) {
				swap(array, j, k--);
			} else if (array[j] == 0) {
				j++;
			} else {
				j++;
				i++;
			}
		}
		return array;
	}
}




