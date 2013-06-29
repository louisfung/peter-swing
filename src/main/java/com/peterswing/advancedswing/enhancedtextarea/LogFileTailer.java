package com.peterswing.advancedswing.enhancedtextarea;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.IOUtils;

public class LogFileTailer extends Thread {
	/**
	 * How frequently to check for file changes; defaults to 5 seconds
	 */
	private long sampleInterval = 1000;

	/**
	 * The log file to tail
	 */
	private File logfile;

	/**
	 * Defines whether the log file tailer should include the entire contents of
	 * the exising log file or tail from the end of the file when the tailer
	 * starts
	 */
	private boolean startAtBeginning = false;

	/**
	 * Is the tailer currently tailing?
	 */
	private boolean tailing = false;

	/**
	 * Set of listeners
	 */
	private Set listeners = new HashSet();

	//	public LogFileTailer(File file) {
	//		this.logfile = file;
	//	}

	public LogFileTailer(File file, long sampleInterval) {
		this.logfile = file;
		this.sampleInterval = sampleInterval;
	}

	public void addLogFileTailerListener(LogFileTailerListener l) {
		this.listeners.add(l);
	}

	public void removeLogFileTailerListener(LogFileTailerListener l) {
		this.listeners.remove(l);
	}

	protected void fireNewLogFileLine(String line) {
		for (Iterator i = this.listeners.iterator(); i.hasNext();) {
			LogFileTailerListener l = (LogFileTailerListener) i.next();
			l.newLogFileLine(line);
		}
	}

	public void stopTailing() {
		this.tailing = false;
	}

	public void run() {
		// The file pointer keeps track of where we are in the file
		long filePointer = 0;

		// Determine start point
		if (this.startAtBeginning) {
			filePointer = 0;
		} else {
			filePointer = this.logfile.length();
		}

		try {
			// Start tailing
			this.tailing = true;
			if (!logfile.exists()) {
				logfile.createNewFile();
			}
			RandomAccessFile file = new RandomAccessFile(logfile, "r");
			while (this.tailing) {
				try {
					long fileLength = this.logfile.length();
					if (fileLength < filePointer) {
						file.close();
						file = new RandomAccessFile(logfile, "r");
						filePointer = 0;
					}

					if (fileLength > filePointer) {
						file.seek(filePointer);
						String line = file.readLine();
						String buffer = "";
						int lineCount = 0;
						while (line != null) {
							buffer += line + System.getProperty("line.separator");
							if (lineCount >= 500) {
								this.fireNewLogFileLine(buffer);
								buffer = "";
								lineCount = 0;
							}
							line = file.readLine();
							lineCount++;
						}
						this.fireNewLogFileLine(buffer);
						filePointer = file.getFilePointer();
					}

					// Sleep for the specified interval
					sleep(this.sampleInterval);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
