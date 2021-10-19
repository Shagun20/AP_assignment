
import java.util.*;
public class Lecture_videos implements Lecture {

	
	private String lecture_topic,file_name;
	private java.util.Date date_uploaded;
	private int id;//id of prof who uploaded these lecture videos
	
	Scanner sc=new Scanner(System.in);
	
	
	
	public Lecture_videos(int id) {
		this.id=id;
	}
	//setter fn
	public void upload() {
		date_uploaded=new java.util.Date();
		System.out.println("Enter topic of video:");
		this.lecture_topic=sc.nextLine();
		while(true){
			System.out.println("Enter filename of video:");
			this.file_name=sc.nextLine();
			 String c= this.file_name.substring(this.file_name.length()-4,this.file_name.length());
			if(!c.equals(".mp4")) {
				System.out.println("Wrong file format");
				System.out.println("Enter the file again !");
			}
			else
				{
				
				break;
				}
		}
	}
	
	
	public void view() {
		System.out.println("Title of video:"+this.lecture_topic);
		System.out.println("Video file:"+this.file_name);	
		System.out.println("Date of upload:"+this.date_uploaded);
		System.out.println("Uploaded by: I"+this.id);
		
	}
}
