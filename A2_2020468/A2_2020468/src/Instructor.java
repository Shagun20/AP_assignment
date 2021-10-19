

import java.util.ArrayList;

public class Instructor {
	
	private int id;
	private int i=0;
	private ArrayList<Test> opened_assessments=new ArrayList<Test>();
	//when an assessments are viewed, they are opened.
	public void view_assessments(Test assessment) {
		
		this.opened_assessments.add(assessment);
		
	}
	
	public void close_assessment(int id) {
		this.opened_assessments.remove(id);
	}
	public  ArrayList<Test> get_opened_assessments(){
		return this.opened_assessments;
	}
	public Instructor(int id) {
		this.id=id;
	}

	public void upload(Lecture l) {
		l.upload();
	}
	
	//upload assignment or quiz
	public void upload(Test t) {
		t.upload();
		//assessments.add(t);
	}
	
}
