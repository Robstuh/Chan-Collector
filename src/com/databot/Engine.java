package com.databot;

import com.databot.forum.Thread;
import com.databot.forum.ThreadCollection;
import com.databot.image.ImageCollection;

public class Engine {

	public static void main(String[] args) {

		Terminal term = Terminal.getInstance();
		term.open(0, 0, 700, 700);
		Terminal.getInstance().showPrintLine("Collecting threads from /g/");
		for(int i = 2; i < 5; i++){
			Terminal.getInstance().showPrintLine("Collecting page " + i + "...");
			ThreadCollection.collectThreads("g", i);
			
		}
		Terminal.getInstance().showPrintLine(
				ThreadCollection.threads.size() + " threads collected.");
		Terminal.getInstance().showPrintLine(
				"Collecting images from threads...");
		for (Thread thread : ThreadCollection.threads) {
			ImageCollection.collectImages("s", thread.getThreadId());

			Terminal.getInstance().showPrintLine(
					"Found " + thread.images.size() + " images in "
							+ thread.getThreadName());
		}
		/*for (Thread thread : ThreadCollection.threads) {
			Terminal.getInstance().showPrintLine(
					thread.getThreadId() + " " + thread.getThreadName()
							+ " contains " + thread.images.size() + " images.");
		}*/
	}
}
