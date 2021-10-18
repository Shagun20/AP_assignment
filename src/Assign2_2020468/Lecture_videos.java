package Assign2_2020468;
import java.util.*;
public class Lecture_videos implements Lecture {

	Scanner sc=new Scanner(System.in);
	private String lecture_topic,file_name;
	
	public void upload() {
		System.out.println("Enter topic of video:");
		this.lecture_topic=sc.nextLine();
		System.out.println("Enter filename of video:");
		this.file_name=sc.nextLine();
	}
	public void view() {
		
	}
}
