package com.test.cb;

import java.util.Scanner;

/*
 * 
 *  Java program for NumberGuess. 		  
*/

public class MyNumberGuessGame {
	public enum NuberGuessEnum {
		HIGHER("higher"), LOWER("lower"), YES("yes"), NO("no");

		private String value;

		NuberGuessEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}



	private Scanner input = new Scanner(System.in);
	private String playerName;
	private long lowerLimit;
	private long upperLimit;
	private int numberOfTrails=1;

	public static void main(String[] args) {
		MyNumberGuessGame numberGame = new MyNumberGuessGame();
		numberGame.playOneGame();
	}

	public int playOneGame() {
		long guess=0;
		String userResponse;
		boolean temp = true;
		playerName = getPlayerName();
		setLimits();

		one: do // do while loop to make number guesses until correct number is
				// found
		{
			guess = Midpoint(lowerLimit, upperLimit);
			userResponse = getUserResponseToGuess(guess);
			if (userResponse.equalsIgnoreCase(NuberGuessEnum.HIGHER.getValue())) {
				lowerLimit = guess;
				++numberOfTrails;
			} else if (userResponse.equalsIgnoreCase(NuberGuessEnum.LOWER
					.getValue())) {
				upperLimit = guess;
				++numberOfTrails;
			} else if (userResponse.equalsIgnoreCase(NuberGuessEnum.YES
					.getValue())) {
				temp = shouldPlayAgain();
				if (temp) {
					userResponse = "";
					setLimits();
					numberOfTrails=1;
					continue one;
				} else {
					break one;
				}
			} else {
				System.out.print("Please enter (higher/lower/yes) only... \n");
			}
		} while (!(userResponse.equalsIgnoreCase(NuberGuessEnum.YES.getValue()))
				&& temp);
		input.close();
		return numberOfTrails;
	}

	public boolean shouldPlayAgain() {
		System.out.print("Hurriahhhh !!!!!  You found in  " + numberOfTrails
				+ "  number of trails \n");

		System.out.print("Would you like to play again? (yes/no): ");

		// Scanner input = new Scanner(System.in);
		String value = input.next();

		if (!(value.equalsIgnoreCase(NuberGuessEnum.YES.toString()) || value
				.equalsIgnoreCase(NuberGuessEnum.NO.toString()))) {
			System.out.print("Please enter (yes/no) only... \n");
			value = input.next();
		}

		return (value.equalsIgnoreCase(NuberGuessEnum.YES.getValue())) ? true
				: false;
	}

	public String getUserResponseToGuess(long guess) {
		// Scanner input = new Scanner(System.in);

		String response;
		System.out.print("Is the number " + guess + "? (higher/lower/yes): ");

		response = input.next();
		System.out.println("RESONSE : " + response);
		return response;
	}

	public long Midpoint(long low, long high) {
		long midpoint;
		midpoint = (high + low) / 2;
		return midpoint;
	}

	public String getPlayerName() {
		System.out.println("Hi there! What's your name?");
		playerName = input.nextLine();
		System.out.println("Hi " + playerName + ", let's play!");
		return playerName;
	}

	public void setLimits() {
		
		/* 
		 Limits can be preset without asking the user. Otherwise we also take the upperLimit max digit length and
		 come up with the upperLimit (eg: user enter digit 4 ... we can put logic as 9999 ).
		 To simplify I am directly getting the user input.		  
		 */
		System.out
				.println("Please enter the Lower Limit of the Guessing a number:\t");
		lowerLimit = input.nextInt();
		System.out
				.println("Please enter the Upper Limit of the Guessing a number:\t");
		upperLimit = input.nextInt();
	}

	public long getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(long lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public long getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(long upperLimit) {
		this.upperLimit = upperLimit;
	}

	public int getNumberOfTrails() {
		return numberOfTrails;
	}

	public void setNumberOfTrails(int numberOfTrails) {
		this.numberOfTrails = numberOfTrails;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}	
}