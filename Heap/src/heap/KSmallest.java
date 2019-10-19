package heap;
import java.util.*;

public class KSmallest {
	public int[] kSmallest(int[] array, int k) {
	    // corner case
	    if (array.length == 0 || k == 0) {
	      return new int[0];
	    }
	    quickSelect(array, 0, array.length - 1, k - 1);
	    int[] result = Arrays.copyOf(array, k);
	    Arrays.sort(result);
	    return result;
	  }
	  
	  private void quickSelect(int[] array, int left, int right, int k) {
	    if (left >= right) {
	      return;
	    }
	    int pivotIdx = partition(array, left, right);
	    if (k == pivotIdx) {
	      return;
	    } else if (k < pivotIdx) {
	      quickSelect(array, left, pivotIdx - 1, k);
	    } else {
	      quickSelect(array, pivotIdx + 1, right, k);
	    }
	  }
	                  
	  private int partition(int[] array, int left, int right) {
	    int pivotIdx = left + (int)(Math.random() * (right - left + 1));
	    int pivot = array[pivotIdx];
//		int pivot = array[right];
	    swap(array, pivotIdx, right);
	    int leftBound = left;
	    int rightBound = right - 1;
	    while (leftBound <= rightBound) {
	      if (array[leftBound] <= pivot) {
	        leftBound++;
	      } else if (array[rightBound] > pivot) {
	        rightBound--;
	      } else {
	        swap(array, leftBound++, rightBound--);
	      }
	    }
	    swap(array, leftBound, right);
	    return leftBound;
	  }
	  
	  private void swap(int[] array, int a, int b) {
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	  }
}
