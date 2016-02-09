package com.databot.image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import com.databot.Config;
import com.databot.forum.Board;
import com.databot.forum.Thread;
import com.databot.forum.ThreadCollection;

public class ImageCollection {

	/**
	 * @paramstore images in a vector
	 */
	static Vector<Image> images = new Vector<Image>();

	public static void collectImages(String board, int thread) {
		try {
			URL url = new URL("http://boards.4chan.org/" + board + "/thread/"
					+ thread);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/4.76");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				// System.out.println(line);
				String[] lines = line.split("\"");
				for (int i = 0; i < lines.length; i++) {
					if (lines[i].contains(Config.CHAN_IMAGE_HOST_URL)) {
						lines[i] = lines[i].replace("//", "");
						// System.out.println(lines[i]);
						Thread t = ThreadCollection.threads
								.get(ThreadCollection.getThreadSlot(thread));

						t.setThreadId(thread);
						Board b = new Board();
						b.setBoard(board);
						b.getThreads().add(t);
						Image image = new Image(b, t, lines[i]);
						if (!t.imageAdded(lines[i])) {
							t.images.add(image);
						}
					}
				}
			}
			in.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean imageAdded(String url) {
		for (Image image : images) {
			if (image.getUrl().equalsIgnoreCase(url))
				return true;
		}
		return false;
	}

	public static void printHtmlDoc() {
		for (Image image : images) {
			System.out.println("<img src=\"http://" + image.getUrl()
					+ "\"/><br>");
		}
	}
}
