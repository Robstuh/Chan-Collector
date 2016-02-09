package com.databot.image;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.databot.task.DownloadTask;

public class ImageDownloader {

	public static void downloadImages() {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		for (Image image : ImageCollection.images) {
			DownloadTask dl = new DownloadTask(image);
			pool.submit(dl);
		}
		pool.shutdown();
		try {
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
