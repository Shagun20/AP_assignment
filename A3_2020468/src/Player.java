
public class Player {
private String name;
private int score=0;
public Player(String n) {
	this.name=n;
}
public String get_name() {
	return this.name;
}
public void set_score(int marks) {
	this.score=marks;
}
public int get_score() {
	return this.score;
}

}
