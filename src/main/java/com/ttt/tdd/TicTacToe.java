package com.ttt.tdd;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';

	public void play(int row, int column) {
		if (board[column - 1][row - 1] != '\0') {
			throw new RuntimeException("Field is occupied!");
		}
		if (column < 1 || column > 3) {
            throw new RuntimeException("X value is outside the board!");
        }
		else if (row < 1 || row > 3) {
            throw new RuntimeException("Y value is outside the board!");
        }
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';

	}

}
