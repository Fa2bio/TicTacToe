package com.github.Fa2bio.TicTacToe;

import com.github.Fa2bio.TicTacToe.model.Board;
import com.github.Fa2bio.TicTacToe.vision.Console;

public class Application {
	public static void main(String[] args) {
		Board board = new Board();
		new Console(board);
	}
}
