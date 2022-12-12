package tictacttoe.entity;

import tictacttoe.constant.Constant;
import tictacttoe.constant.Constant.PlayerStatus;

public abstract class Players {
private int gameId;
private Symbol symbol;
private Constant.PlayerType playerType;
private PlayerStatus playerStatus;
public int getGameId() {
	return gameId;
}
public Players(Symbol symbol,Constant.PlayerType type) {
	this.symbol=symbol;
	this.playerType=type;
}
public Symbol getSymbol() {
	return symbol;
}

public void setSymbol(Symbol symbol) {
	this.symbol = symbol;
}

public Constant.PlayerType getPlayerType() {
	return playerType;
}

public void setPlayerType(Constant.PlayerType playerType) {
	this.playerType = playerType;
}

public void setGameId(int gameId) {
	this.gameId = gameId;
}

public PlayerStatus getPlayerStatus() {
	return playerStatus;
}
public void setPlayerStatus(Constant.PlayerStatus playerStatus) {
	this.playerStatus = playerStatus;
}
public abstract Move makeMove(Board board);
}
