

public interface Test {
	 void upload();
	void view();
	void add_grade(int grade,int grade_id);
	
	//for inst
	
	//void submit();
	int view_grade();
	//public boolean get_status();
	public String file();
	public int get_id();
	public String getprobemstat();
	public int getmaxmarks() ;
	public void copy(Test t);
	public void submit();
	//for student
	
}
