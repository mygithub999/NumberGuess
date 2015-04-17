package com.test.cb;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyNumberGuessGameTest {
	
	@Test
	public void testGuessGame (){
		 MyNumberGuessGame  numberGame = new MyNumberGuessGame();
	     assertNotNull(numberGame.getPlayerName());
	     
	     assertNotNull(numberGame.getUserResponseToGuess(50));
	     assertEquals(numberGame.Midpoint(50, 100), 75);
	     
	     assertNotNull(numberGame.shouldPlayAgain());
	     assertNotNull(numberGame.playOneGame());
	}

}
