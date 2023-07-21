package com.ttt.tdd;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';

	public void play(int row, int column) {
//		if (board[column - 1][row - 1] != '\0') {
//			throw new RuntimeException("Field is occupied!");
//		}
		checkAxis(column, "X value is outside the board!");
		checkAxis(row, "Y value is outside the board!");
        setField(column, row);

	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';

	}

	private void checkAxis(int axis, String message) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException(message);
		}
	}

	 private void setField(int column, int row) {
	        if (board[column - 1][row - 1] != '\0') {
	            throw new RuntimeException("Field is occupied!");
	        } else {
	            board[column - 1][row - 1] = 'X';
	        }
	    }
}
