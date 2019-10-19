package laioffer;

public class Student {

	private String name;
	private static String school = "Laioffer";
	private int age;
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student a = new Student("Tom");
		System.out.println(Student.school);
		
	}

}
