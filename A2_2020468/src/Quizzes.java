
import java.util.*;
public class Quizzes implements Test{
	private String question;
	private int grades=-1;
	private int max_marks=1;
	private String ans;
	private int id;
	private int grade_id;
	
	public Quizzes(int id) {
		this.id=id;
	}
	
	Scanner sc=new Scanner(System.in);
	public void upload() {
		
		System.out.print("Enter quiz question:");
		this.question=sc.nextLine();
	}
	
	public void copy(Test t) {
		this.question=t.getprobemstat();
		
	}
	public void view() {
		System.out.println("Question: "+this.question+"\r"+"----------------");
	
	}
	public void add_grade(int grade,int grade_id) {
		this.grades=grade;
		this.grade_id=grade_id;
	}
	
	//for inst
	
	public String file() {
		return this.ans;
	}
	public int get_id() {
		return this.grade_id;
	}
	public int view_grade() {
		return this.grades;
	}
	public String getprobemstat() {
		return this.question;
	}
	public int getmaxmarks() {
		return 1;
	}
	
	public void submit() {
		System.out.print(this.question);
		this.ans =sc.nextLine();
		//ans input from student
		
	}

}

