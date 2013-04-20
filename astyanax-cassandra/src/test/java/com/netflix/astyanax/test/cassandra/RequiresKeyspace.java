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

import org.apache.cassandra.locator.AbstractReplicationStrategy;
import org.apache.cassandra.locator.SimpleStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a test as requiring that the defined Keyspace be present.
 *
 * @author zznate
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequiresKeyspace {
  String ksName();

  /**
   * The replication factor. Defaults to 1
   * @return
   */
  int replication() default 1;

  /**
   * The replication strategy. Defaults to SimpleStrategy.class
   * @return
   */
  Class<? extends AbstractReplicationStrategy> strategy() default SimpleStrategy.class;

  /**
   * String representation of the strategy options
   * @return
   */
  String strategyOptions() default "";

}
