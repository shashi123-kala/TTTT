package com.ttt.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {
	
	TicTacToe ticTacToe = new TicTacToe();
	@Rule
	public ExpectedException exception = ExpectedException.none();
	public static final Character FIRST_PLAYER = 'X';
	public static final Character SECOND_PLAYER = 'O';
	public static final String X_IS_THE_WINNER = "X is the Winner";
	
	//1
	@Test
	public void initializeNewTicTacToeGame() {
		assertNotNull(ticTacToe);
	}
	
	
//2
	@Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
    }
	
	//3
	@Test
    public void startGameWithFirstPlayer() {
        assertEquals(FIRST_PLAYER, ticTacToe.nextPlayer());
    }
	
	//4
	@Test
    public void givenLastTurnWasXWhenNextPlayerThenO() {
        ticTacToe.play(1,1);
        assertEquals(SECOND_PLAYER, ticTacToe.nextPlayer());
    }
	
	//5
	@Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }
	
	//6
	@Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2, 6);
    }

	//7
	@Test
	 public void playWithVerticalLine() {
        ticTacToe.play(1,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,1); // X
        ticTacToe.play(2,2); // O
        String actual = ticTacToe.play(3,1); // X        
        assertEquals(X_IS_THE_WINNER, actual);
    }
	
	//8
	public void playWithHorizontalLine() {
        ticTacToe.play(2,1); // X
        ticTacToe.play(1,1); // O
        ticTacToe.play(3,1); // X
        ticTacToe.play(1,2); // O
        ticTacToe.play(2,2); // X
        String actual = ticTacToe.play(1,3); // O
        assertEquals("O is the Winner", actual);
    }
	
	  @Test
	    public void playWithDiagonalLeft() {
	        ticTacToe.play(1,1); // X
	        ticTacToe.play(1,2); // O
	        ticTacToe.play(2,2); // X
	        ticTacToe.play(1,3); // O
	        String actual = ticTacToe.play(3,3); // X
	        assertEquals("X is the Winner", actual);

	    }
	  @Test
	    public void playWithDiagnoalRight() {
	        ticTacToe.play(1,3); // X
	        ticTacToe.play(1,1); // O
	        ticTacToe.play(2,2); // X
	        ticTacToe.play(1,2); // O
	        String actual = ticTacToe.play(3,1); // X
	        assertEquals("X is the Winner", actual);
	    }
	
	
}
