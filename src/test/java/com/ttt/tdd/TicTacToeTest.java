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
	
	@Test
	public void initializeNewTicTacToeGame() {
		assertNotNull(ticTacToe);
	}
	
	@Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
    }
	
	@Test
    public void startGameWithFirstPlayer() {
        assertEquals(FIRST_PLAYER, ticTacToe.nextPlayer());
    }
	
	@Test
    public void givenLastTurnWasXWhenNextPlayerThenO() {
        ticTacToe.play(1,1);
        assertEquals(SECOND_PLAYER, ticTacToe.nextPlayer());
    }

	
	
}
