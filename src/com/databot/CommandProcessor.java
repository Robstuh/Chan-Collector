package com.databot;

import com.databot.forum.ThreadCollection;

public class CommandProcessor {
	private CommandProcessor() {
	}

	public void processCmd(String command) {
		if (command.equalsIgnoreCase("threads")) {

			Terminal.getInstance().showPrintLine(
					ThreadCollection.threads.size()
							+ " threads have been stored.");
		}
	}

	public static CommandProcessor getInstance() {
		return CommandProcessorHolder.INSTANCE;
	}

	private static final class CommandProcessorHolder {
		static final CommandProcessor INSTANCE = new CommandProcessor();
	}
}