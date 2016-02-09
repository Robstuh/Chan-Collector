package com.databot.forum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

public class ThreadCollection {

	// TODO make threads collectable on specific pages
	// TODO
	// TODO
	// TODO

	public static Vector<Thread> threads = new Vector<Thread>();

	public static int getThreadSlot(int id) {
		for (int i = 0; i < threads.size(); i++) {
			if (id == threads.get(i).getThreadId()) {
				return i;
			}
		}
		return -1;
	}

	public static void collectThreads(String board) {
		try {
			URL url = new URL("http://boards.4chan.org/" + board + "/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/4.76");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				String[] lines = line.split("\"");
				for (int i = 0; i < lines.length; i++) {
					if (lines[i].contains("thread/")) {
						lines[i] = lines[i].replace("thread/", "");
						if (!lines[i].startsWith("/" + board + "/")
								&& !lines[i].contains("#")
								&& lines[i].contains("/")) {
							String[] data = lines[i].split("/");
							Thread t = new Thread();
							t.setThreadId(Integer.parseInt(data[0]));
							t.setThreadName(data[1]);
							threads.add(t);
						}
					}
				}
			}
			in.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
