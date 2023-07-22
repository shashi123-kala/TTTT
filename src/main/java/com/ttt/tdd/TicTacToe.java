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
		for (int i = 0; i < SIZE; i++) {
			// if (board[0][i] + board[1][i] + board[2][i] == (lastPlayer * SIZE)) {
			String str1 = board[0][i].toString();
			String str2 = board[1][i].toString();
			String str3 = board[2][i].toString();
			StringJoiner stj = new StringJoiner("");
			stj.add(str1);
			stj.add(str2);
			stj.add(str3);
			String s = stj.toString();
			String l = String.valueOf(lastPlayer);
			System.out.println(s);
			if (s.contains(l) && s.length() == 3) {
				System.out.println("hf");
				return true;
			}
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
