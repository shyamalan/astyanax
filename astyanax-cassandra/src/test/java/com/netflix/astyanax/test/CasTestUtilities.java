package com.netflix.astyanax.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.db.commitlog.CommitLog;
import org.apache.cassandra.io.util.FileUtils;

public class CasTestUtilities {
	/**
	 * @throws IOException
	 */
	public static void cleanupDB() throws IOException {
		mkDBDirs();
		cleanupDBDirs();
		mkDBDirs();
		CommitLog.instance.resetUnsafe();
	}

	/**
	 * @throws IOException
	 */
	public static void cleanupDBDirs() throws IOException {
		// clean up commitlog
		final String [] directoryNames = {DatabaseDescriptor.getCommitLogLocation(),};
		for (final String dirName: directoryNames) {
			final File dir = new File(dirName);
			if (!dir.exists())
				throw new RuntimeException("No such directory: " + dir.getAbsolutePath());
			FileUtils.deleteRecursive(dir);
		}

		// clean up data directory which are stored as data directory/table/data files
		for (final String dirName: DatabaseDescriptor.getAllDataFileLocations()) {
			final File dir = new File(dirName);
			if (!dir.exists())
				throw new RuntimeException("No such directory: " + dir.getAbsolutePath());
			FileUtils.deleteRecursive(dir);
		}
	}

	/**
	 * @param resource
	 * @param file
	 * @throws IOException
	 */
	public static void copy(final String resource, final File file) throws IOException {
		file.getParentFile().mkdirs();
		final InputStream is = CasTestCommon.class.getResourceAsStream(resource);
		final OutputStream out = new FileOutputStream(file);
		final byte buf[] = new byte [1024];
		int len;
		while ((len = is.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		out.close();
		is.close();
	}

	/**
	 * 
	 */
	public static void mkDBDirs() {
		DatabaseDescriptor.createAllDirectories();
	}

}
