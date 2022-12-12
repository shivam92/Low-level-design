package tictacttoe.entity;

public class Cell {

	private Players player;
	private int row;
	private int col;
	public Players getPlayer() {
		return player;
	}
	public void setPlayer(Players player) {
		this.player = player;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
}
