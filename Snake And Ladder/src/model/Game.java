package model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import service.DiceServie;




public class Game {

	private Board board;
	
	int diceCount;
	int dimention;
	int size;
	private Queue<Player> players;//choose because turn will come in the way who has come fisrt
	private Queue<Player> winners;
	
	private Game() {
		this.players=new LinkedList();
	}
	public Board getBoard() {
		return board;
	}
	
	
	
	public static class Builder{
		private Game game;
		public Builder() {
			game=new Game();
			
		}
		
		public Builder setDimension(int dimension) {
			game.dimention=dimension;
			game.size=dimension*dimension;
			game.board=new Board(dimension);
			return this;
		}
		public Builder addPlayer(Player player) {
			game.players.add(player);
			return this;
		}
		public Builder setDieceCount(int count ) {
			game.diceCount=count;
			return this;
		}
		public Game build() {
			return game;
		}
		
	}



	public int getDiceCount() {
		return diceCount;
	}
	public void setDiceCount(int diceCount) {
		this.diceCount = diceCount;
	}
	public int getDimention() {
		return dimention;
	}
	public void setDimention(int dimention) {
		this.dimention = dimention;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Queue<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Queue<Player> players) {
		this.players = players;
	}
	public Queue<Player> getWinners() {
		return winners;
	}
	public void setWinners(Queue<Player> winners) {
		this.winners = winners;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	
	private void printPosition() {
		for(Player player:players) {
			System.out.println(player.getName()+":"+player.getPosition());
		}
	}
	
	private void makeMove(Player player) {
		int curPosition =player.getPosition();
		int move=DiceServie.roll(diceCount);
		System.out.println("You got: "+move);
		int finalPosition=move+curPosition;
		if(finalPosition<=size) {
			if(board.hasSnakeLadder(finalPosition)) {
				
				finalPosition=board.getCell(finalPosition).getEnd();
				System.out.println("Taking you to "+finalPosition);
			}
		}else {
			System.out.println("Try again in the next turn.");
			finalPosition=curPosition;
		}
		player.setPosition(finalPosition);
		
		
	}
	
	public void launc() {
		this.board.printBoard();
		while(players.size()>1) {
			Player currPlayer=players.poll();
			System.out.println();
			System.out.println(currPlayer.getName()+"'s turn.");
			System.out.println("Press 'r' to roll the dice.");
			Scanner sc = new Scanner(System.in);
			char c = sc.next().charAt(0);
			makeMove(currPlayer);
			//
			if (currPlayer.getPosition() == size) {
				System.out.println(currPlayer.getName() + " won!!!");
				winners.add(currPlayer);
			}else {
				players.add(currPlayer);
			}
			printPosition();
		}
	}
}
