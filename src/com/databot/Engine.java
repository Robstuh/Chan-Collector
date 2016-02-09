package com.databot;
import com.databot.forum.Thread;
import com.databot.forum.ThreadCollection;
import com.databot.image.ImageCollection;

public class Engine {

	public static void main(String[] args) {

		ThreadCollection.collectThreads("s");
		for (Thread thread : ThreadCollection.threads) {
			ImageCollection.collectImages("s", thread.getThreadId());
		}
		for (Thread thread : ThreadCollection.threads) {
			System.out.println(thread.getThreadId() + " " + thread.getThreadName() + " contains "
					+ thread.images.size() + " images.");
		}
	}
}
