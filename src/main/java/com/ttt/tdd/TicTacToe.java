package com.ttt.tdd;

import java.util.StringJoiner;

public class TicTacToe {
	private static final int SIZE = 3;
	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';

	public String play(int column, int row) {
		checkAxis(column, "X value is outside the board!");
		checkAxis(row, "Y value is outside the board!");
		lastPlayer = nextPlayer();
		setField(column, row, lastPlayer);
		// return checkWin();
		if (isWinner()) {
			return lastPlayer + " is the Winner";
		}
		return "No winner";
	}

	private boolean isWinner() {
		char diagonal1 = '\0';
        char diagonal2 = '\0';
		for (int i = 0; i < SIZE; i++) {
	        
			diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
            
			String playr = String.valueOf(lastPlayer);
			String horizontal = board[0][i].toString().concat(board[1][i].toString()).concat(board[2][i].toString());
			String vertical = board[i][0].toString().concat(board[i][1].toString()).concat(board[i][2].toString());
			String bottomDiagonalLeft = board[0][0].toString().concat(board[1][1].toString())
					.concat(board[2][2].toString());
			String bottomDiagonalRight = board[2][0].toString().concat(board[1][1].toString())
					.concat(board[0][2].toString());

			if (horizontal.contains(playr) && horizontal.length() == 3)
				return true;

			else if (vertical.contains(playr) && vertical.length() == 3)
				return true;

			else if (diagonal1 == bottomDiagonalLeft.length() || diagonal2 ==bottomDiagonalRight.length())
				return true;
			

			// }
		}

		return false;
	}

	private void setField(int column, int row, char lastPlayer) {
		if (board[column - 1][row - 1] != '\0') {
			throw new RuntimeException("Field is occupied!");
		} else {
			board[column - 1][row - 1] = lastPlayer;
		}
	}

	private void checkAxis(int axis, String message) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException(message);
		}
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
}
