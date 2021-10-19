

import java.util.*;

public class Student {
	
	private int id;
	private ArrayList<Test> pending_assessments=new ArrayList<Test>();
	private ArrayList<Test> submitted_assessments=new ArrayList<Test>();
	private Test t1;
	
	
	Scanner sc=new Scanner(System.in);
	
	public void add(Test t,Test t1) {
		this.t1=t1;
		this.t1.copy(t);
		pending_assessments.add(t1);
		//System.out.println("1");
		
		//reference to assessments
	}
	public Student() {
		
	}
	public Student(int id) {
		this.id=id;
	}
	public void view (Lecture l) {
		
		l.view();
	}
	
	public void view(Test t) {
		t.view();
		
	}
	public void submit() {
		System.out.println("Pending assessments");
		for(int i=0;i<this.pending_assessments.size();i++) {
			System.out.print("ID :"+i+"\t");
			this.pending_assessments.get(i).view();
		}
		if(this.pending_assessments.size()!=0) {
		System.out.print("Enter ID of assessment:");
		int id=sc.nextInt();
		sc.nextLine();
		this.pending_assessments.get(id).submit();		
		this.submitted_assessments.add(this.pending_assessments.get(id))	;
		this.pending_assessments.remove(id);
		
		}
		else
			System.out.println("No pending assessments");
	}
	
	public void remove_assessment(Test t) {
		//search for the assessment in pending_assess
		int in=-1;
		for(int i=0;i<this.pending_assessments.size();i++) {
			if(this.pending_assessments.get(i).getprobemstat().equals(t.getprobemstat())) {
				//System.out.print("Yess");
				in=i;
				break;
			}
		}
		if(in!=-1) {
			this.pending_assessments.remove(in);
		}
		
	}
	
	
	public ArrayList<Test> get_submitted_assessments(){
		return this.submitted_assessments;
	}
	public void view_grade() {
		System.out.println("Graded submissions "+"\n");
		for(int i=0;i<this.submitted_assessments.size();i++) {
			
			if(this.submitted_assessments.get(i).view_grade()!=-1) {
				System.out.println("Submission: " +this.submitted_assessments.get(i).file());
				System.out.println("Marks scored: "+this.submitted_assessments.get(i).view_grade());
				System.out.println("Graded by: I"+this.submitted_assessments.get(i).get_id());
			}
			}
		System.out.println("Ungraded submissions");
			for(int i=0;i<this.submitted_assessments.size();i++) {
				if(this.submitted_assessments.get(i).view_grade()==-1) 
					System.out.println("Submission: " +this.submitted_assessments.get(i).file()+"\n");
				
			}
			
			
	}
	}


