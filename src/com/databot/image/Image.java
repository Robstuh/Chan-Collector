package com.databot.image;

import com.databot.forum.Board;
import com.databot.forum.Thread;

public class Image {

	public Image(Board board, Thread thread, String url) {
		this.setBoard(board);
		this.setThread(thread);
		this.setUrl(url);
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Thread getThread() {
		return thread;
	}

	private Thread thread;
	private String url;
	public Board board;
}
