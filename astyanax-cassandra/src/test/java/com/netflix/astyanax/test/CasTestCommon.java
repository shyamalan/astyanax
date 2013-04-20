package com.netflix.astyanax.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cassandra.service.CassandraDaemon;
import org.apache.log4j.Logger;
import com.netflix.astyanax.util.Time;



public class CasTestCommon {
	public enum SchemaType {
		STRINGSTRING,STRINGLONG,UUIDSTRING
	}
	private static boolean isInited = false;
	private static boolean useEmbedded = true;
	private static CassandraDaemon casDaemon;
	private static Logger logger = Logger.getLogger(CasTestCommon.class);
	private static ExecutorService	fExecutor;
	protected Logger getLogger() {
		return logger;
	}
	protected void setUp() {
	  getLogger().info("Setting Up Test");
	  if (!isInited) {
		  if (useEmbedded) {
			  getLogger().info("Using Embedded Cassandra...");
				fExecutor = Executors.newSingleThreadExecutor();
				fExecutor.execute(new Runnable() {

					@Override
					public void run() {
						casDaemon = new CassandraDaemon();
						casDaemon.activate();
					}
				});
				if (casDaemon == null) {
					final Time start = Time.currentTime();
					System.out.println("Sleeping.  Waiting for cassandra daemon...");
					while (casDaemon == null)
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					getLogger().info("Had to wait for " + Time.currentTime().minus(start));
				}
		  }
	  }
		 
	}
	protected void teardown() {
	    
	}

}
