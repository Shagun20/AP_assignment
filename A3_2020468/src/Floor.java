
public  class Floor {
	private int location=0;
	private int points=1;
	
	
    public void print_location(int l) {
    	this.location=l;
    	System.out.println("Player position Floor-"+this.location);
    	//not overwritten
    	
    }
	public  void print_message(Player p) {
		
		System.out.println(p.get_name()+" has reached an Empty Floor");
		//overwrittern by child classes 
	}
	
	public  void update_points(Player p) {
		int marks=p.get_score()+ this.points;
		
		p.set_score(marks);
		System.out.println("Total points "+p.get_score());
		//overwitten by child class
	}

}
