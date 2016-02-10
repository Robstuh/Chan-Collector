package com.databot.task;

import com.databot.image.Image;

public class DownloadTask implements Runnable {

	private Image image;

	public DownloadTask(Image image) {
		// TODO Auto-generated constructor stub
		this.setImage(image);
	}

	@Override
	public void run() {
		// surround with try-catch if downloadFile() throws something
		// downloadFile();
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}