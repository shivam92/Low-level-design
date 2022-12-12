package tictacttoe.entity;

import java.util.ArrayList;
import java.util.List;

import tictacttoe.constant.Constant;

public class Game {
private Board board;
private List<Players>players;
private Constant.GameStatus status;
private int currentPlayer;
private int gameId;
private Players winner;
private Game() {
	players=new ArrayList();
	this.status=Constant.GameStatus.IN_PROGRESS;
	this.nextTurnPlayerIndex = 0;
	 this.moves = new ArrayList<>();
}
public Players getWinner() {
	return winner;
}
public void setWinner(Players winner) {
	this.winner = winner;
}
public int getNextTurnPlayerIndex() {
	return nextTurnPlayerIndex;
}
public void setNextTurnPlayerIndex(int nextTurnPlayerIndex) {
	this.nextTurnPlayerIndex = nextTurnPlayerIndex;
}
public List<Move> getMoves() {
	return moves;
}
public void setMoves(List<Move> moves) {
	this.moves = moves;
}
private int nextTurnPlayerIndex;
private List<Move> moves;
public Board getBoard() {
	return board;
}
public void setBoard(Board board) {
	this.board = board;
}
public List<Players> getPlayers() {
	return players;
}
public void setPlayers(List<Players> players) {
	this.players = players;
}
public Constant.GameStatus getStatus() {
	return status;
}
public void setStatus(Constant.GameStatus status) {
	this.status = status;
}
public int getCurrentPlayer() {
	return currentPlayer;
}
public void setCurrentPlayer(int currentPlayer) {
	this.currentPlayer = currentPlayer;
}
public int getGameId() {
	return gameId;
}
public void setGameId(int gameId) {
	this.gameId = gameId;
}

public static class GameBuilder{
	private Game game;
	public GameBuilder(){
		this.game=new Game();
	}
	public GameBuilder addPlayer(Players p) {
		this.game.getPlayers().add(p);
		return this;
	}
	public GameBuilder setDimension(int rows) {
		Board board=new Board(rows);
		this.game.setBoard(board);
		return this;
	}
	public Game build() {
		return this.game;
	}
}
public void run() throws Exception {
	Players currentMovePlayer = this.players.get(nextTurnPlayerIndex);

    Move move = currentMovePlayer.makeMove(board);

    int moveRow = move.getRow();
    int moveColumn = move.getCol();

    if (board.getBoard().get(moveRow).get(moveColumn).getPlayer() != null) {
        throw new Exception("Cell is not empty");
    }

    board.getBoard().get(moveRow).get(moveColumn).setPlayer(currentMovePlayer);
    move.setCell(board.getBoard().get(moveRow).get(moveColumn));
    moves.add(move);

    System.out.println("Move happened at row: " + moveRow + " Column: " + moveColumn);

	/*
	 * for (GameWinningStrategy gameWinningStrategy: gameWinningStrategies) { if
	 * (gameWinningStrategy.checkVictory(board, move)) { gameStatus =
	 * GameStatus.ENDED; winner = currentMovePlayer; return; } }
	 */

    if (moves.size() == board.getDimension() * board.getDimension()) {
    	status = Constant.GameStatus.DRAW;
        return;
    }

    nextTurnPlayerIndex += 1;
    nextTurnPlayerIndex %= players.size();
}

public void undo() throws Exception {
    if (moves.size() < 1) {
        throw new Exception("Can do ");
    }

    Move lastMove = moves.get(moves.size() - 1);

    this.nextTurnPlayerIndex -= 1; // - 1
    this.nextTurnPlayerIndex += this.players.size(); // 3
    this.nextTurnPlayerIndex %= this.players.size(); // 3

    lastMove.getCell().setPlayer(null);

    moves.remove(moves.size() - 1);

    // 0 0 0 0
    // initially = 0
    // after reduction - 1
    // add players size = 3
    // after mod = 3 % 3 = 3
}
public void printBoard() {
    board.printBoard();
}
}
