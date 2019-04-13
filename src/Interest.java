
public class Interest {

	private String name;
	private int score;
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + " score=" + score + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
