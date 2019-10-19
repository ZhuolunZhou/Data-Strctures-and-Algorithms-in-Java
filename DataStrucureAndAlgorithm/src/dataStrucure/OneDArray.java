/**
 * 
 */
package dataStrucure;

/**
 * @author zhuolunzhou
 *
 */
public class OneDArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = new int[5]; //initialization
		System.out.println(number.length); //use a.length to represent size of array
		for (int i=0; i<5; i++) {
			number[i] = i;
		}
		
		
		Student[] s = new Student[2]; // array of object
		s[0] = new Student("zhuolun",23);
		s[1] = new Student("yujia",23);
		
		for (Student a: s) {
			System.out.println("Student name is "+ a.name + ", age is " + a.age);
		}
	}

}
