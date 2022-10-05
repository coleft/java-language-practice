package array;
public class StudentArrayTest {
	void arrayTest() {	//같은 패키지에서는 접근할 수 있다.
		String[] name = {"kim", "lee", "park", "choi", "nam", "kang", "ahn", "smith", "fine"};
		int[] score = {55,66,77,88,99,44,77,66,22};
		double[] weight = {88,99,77,66,55,11,33,44,55};
		
		//1) 배열선언
		Student[] std = new Student[9];
		
		//2) 배열에 Student 객체 생성 후 대입
		for(int i=0; i<std.length; i++) {
			std[i] = new Student(name[i], score[i], weight[i]);
		}
		
		for(int i=0; i<std.length; i++) {
			System.out.println(std[i]);
			System.out.println("-".repeat(20));
		}
		/*
		// park씨의 성적과 몸무게를 각각 100, 70으로 수정
		int k = -1;
		for(int i = 0; i<std.length; i++) {
			if(std[i].name.equals("nam")) {
				k=i;
				break;
			}
		}		
		
		System.out.println("수정전 : ");
		System.out.println(std[k]);
		std[k].score = 100;
		std[k].weight = 70;
		System.out.println("수정후 : ");
		System.out.println(std[k]);
				*/
	}
	
	public static void main(String[] args) {
		StudentArrayTest st = new StudentArrayTest();
		st.arrayTest();
	}
	
}
