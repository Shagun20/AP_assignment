
public class Snake_floor extends Floor {
	private int location;
	private int points;
	private int move_to_floor;
	private String name;
	
	public Snake_floor(int l,int p,int m,String n) {
		this.location=l;
		this.points=p;
		this.move_to_floor=m;
		this.name=n;
	}
	
	@Override
	public  void print_message(Player p) {
		System.out.println("Oh!"+ p.get_name()+" has reached a "+this.name+" Floor. ");
	}
	
	@Override
	public  void update_points(Player p) {
		int marks = p.get_score()- this.points;
		p.set_score(marks);
		System.out.println("Total points "+p.get_score());
	}
	public int move_to_floor() {
		return this.move_to_floor;
	}//added method in snake
}
