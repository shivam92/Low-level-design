package model;

public class Ladder  extends Cell{

	public Ladder(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ladder "+this.getEnd();
	}
	

}
