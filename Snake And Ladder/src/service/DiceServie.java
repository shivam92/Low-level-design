package service;

public class DiceServie {

	public static int roll(int n) {
		int min=1;
		int max=6;
		return (int)Math.floor(Math.random()*(max-min+1)+min);
	}
}
