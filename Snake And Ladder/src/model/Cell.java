package model;

public class Cell {
 private int start;
 private int end;
 
 public Cell(int x,int y) {
	 this.start=x;
	 this.end=y;
 }

public int getStart() {
	return start;
}

public void setStart(int start) {
	this.start = start;
}

public int getEnd() {
	return end;
}

public void setEnd(int end) {
	this.end = end;
}
 
}
