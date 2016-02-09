package com.databot.task;

import com.databot.image.Image;

public class DownloadTask implements Runnable {

	private Image image;

	public DownloadTask(Image image) {
		// TODO Auto-generated constructor stub
		this.image = image;
	}

	@Override
	public void run() {
		// surround with try-catch if downloadFile() throws something
		// downloadFile();
	}

}