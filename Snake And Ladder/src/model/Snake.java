package model;

public class Snake extends Cell{

	public Snake(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Snake  "+this.getEnd();
	}

}
