package tictacttoe.entity;

import java.util.Scanner;

import tictacttoe.constant.Constant;

public class HumanPlayer extends Players {
	private Scanner scanner;
	public HumanPlayer(Symbol symbol) {
		super(symbol, Constant.PlayerType.Human);
		scanner = new Scanner(System.in);
	}
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public static class Builder{
		HumanPlayer humanPlayers;
		public Builder(Symbol symbol) {
			this.humanPlayers=new HumanPlayer( symbol);
		}
		
		public HumanPlayer.Builder setWithUserId(int st) {
			this.humanPlayers.setUserId(st);
			return this;
		}
		public HumanPlayer build() {
			return this.humanPlayers;
		}
	}
	@Override
	public Move makeMove(Board board) {
		System.out.println("Please tell row number (Starting from 0)");
		int row = scanner.nextInt();
		System.out.printf("Please tell column number (Starting from 0)");
        int col = scanner.nextInt();
        Move move = new Move();
        move.setCol(col);
        move.setRow(row);

        return move;
		
	}
}
