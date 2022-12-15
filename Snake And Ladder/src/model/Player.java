package model;

public class Player extends User {

	private int gameId;
	private int position;
	public int getGameId() {
		return gameId;
	}
	private Player() {
		this.position=0;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public static class PlayerBuilder {
		Player player;
		public PlayerBuilder() {
			player=new Player();
		}
		
		public PlayerBuilder createWithGameId(int gameId) {
			player.gameId=gameId;
			return this;
		}
		public PlayerBuilder createWithName(String name) {
			player.setName(name);
			return this;
		}
		public Player build() {
			return player;
		}
		
	}
	

}
