package sort;
/*
 * Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black,
 * sort the balls such that all balls with same color are grouped together 
 * and from left to right the order is Red->Green->Blue->Black. 
 * (Red is denoted by 0, Green is denoted by 1,  Blue is denoted by 2 and Black is denoted by 3).
 */


public class RainbowSortII {
	public int[] sort(int[] array) {
	    if (array == null || array.length <= 1) {
	      return array;
	    }
	    int red = 0;
	    int green = 0;
	    int blue = 0;
	    int black = array.length - 1;
	    while (blue <= black) {
	      if (array[blue] == 0) {
	        swap(array, red++, blue);
	        if (red > green) {
	          green++;
	        }
	        if (green > blue) {
	          blue++;
	        }
	      } else if (array[blue] == 1) {
	        swap(array, green++, blue++);
	      } else if (array[blue] == 2) {
	        blue++;
	      } else {
	        swap(array, blue, black--);
	      }
	    }
	    return array;
	  }
	  
	  private void swap(int[] array, int a, int b) {
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	  }
}
