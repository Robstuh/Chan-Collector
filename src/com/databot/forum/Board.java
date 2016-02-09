package com.databot.forum;

import java.util.Vector;

public class Board {

	private String board;

	public String toString() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	private Vector<Thread> threads = new Vector<Thread>();

	public Vector<Thread> getThreads() {
		return threads;
	}

	public void setThreads(Vector<Thread> threads) {
		this.threads = threads;
	}

}
