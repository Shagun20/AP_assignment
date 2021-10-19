package Assign2_2020468;
import java.util.*;
public class Assignments implements Test {

	Scanner sc=new Scanner(System.in);
	private String problem_statement;
	private int max_marks;
	private boolean pending=true;
	private int grades=-1;
	private String submit_file_name;
	private int id;
	private int grade_id;
	//setter function
	
	public int opened=0;
	
	public String file() {
		return this.submit_file_name;
	}
	
	public int get_id() {
		return this.grade_id;
	}
	public Assignments(int id) {
		this.id=id;
	}
	
	public void upload() {
		System.out.print("Enter problem statement:");
		this.problem_statement=sc.nextLine();
		
		System.out.print("Enter max marks:");
		this.max_marks=Integer.parseInt(sc.nextLine());
		
	}
	
	
	
	public void copy(Test t) {
		this.problem_statement=t.getprobemstat();
		this.max_marks=t.getmaxmarks();
		
	}
	
	
	public String getprobemstat() {
		return this.problem_statement;
	}
	
	
	
	public int getmaxmarks() {
		return this.max_marks;
	}
	
	public void view() {
		System.out.println("Assignment: "+this.problem_statement+"Max Marks "+this.max_marks+"\r"+"----------------");
		
	}
	public void add_grade(int grades,int grade_id) {
		this.grades=grades;
		this.grade_id=grade_id;
	}
	
	//for inst
	
	public int view_grade() {
		
		return this.grades;
		
	}
	
	public void submit() {
		while(true) {
			System.out.print("Enter filename of assignment: ");
			this.submit_file_name =sc.nextLine();
			String c = this.submit_file_name.substring(this.submit_file_name.length()-4,this.submit_file_name.length());
			if(!c.equals(".zip")) {
				System.out.println("Wrong file format !");
				
			}
			else
				break;
		}
		
		this.pending=false;
		
		
	}
	
}

