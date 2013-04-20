/* 
 *   Copyright 2013 Nate McCall and Edward Capriolo
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
*/
package com.netflix.astyanax.test.cassandra;

import org.apache.cassandra.service.CassandraDaemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PaasDeamon extends CassandraDaemon {

  private static final Logger logger = LoggerFactory.getLogger(PaasDeamon.class);


  private static final PaasDeamon instance = new PaasDeamon();

	public static void main(String[] args) {
		System.setProperty("cassandra-foreground", "true");
		System.setProperty("log4j.defaultInitOverride", "true");
		System.setProperty("log4j.configuration", "log4j.properties");

    instance.activate();
	}

  @Override
  protected void setup() {
    super.setup();
  }

  @Override
  public void init(String[] arguments) throws IOException {
    super.init(arguments);
  }

  @Override
  public void start() {
    super.start();
  }

  @Override
  public void stop() {
    super.stop();
  }
}