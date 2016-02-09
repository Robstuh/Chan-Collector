package com.databot.forum;

import java.util.Vector;

import com.databot.image.Image;

/**
 * 
 */

/**
 * @author Robbie
 *
 */
public class Thread {

	public Vector<Image> images = new Vector<Image>();

	private int threadId;
	private String name;

	public int getThreadId() {
		return threadId;
	}

	public String getThreadName() {
		return name;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public void setThreadName(String name) {
		this.name = name;
	}

	public boolean imageAdded(String url) {
		for (Image image : images) {
			if (image.getUrl().equalsIgnoreCase(url))
				return true;
		}
		return false;
	}
}
