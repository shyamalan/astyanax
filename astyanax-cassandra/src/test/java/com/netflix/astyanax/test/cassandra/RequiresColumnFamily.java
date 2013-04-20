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

import org.apache.cassandra.db.ColumnFamilyType;
import org.apache.cassandra.db.marshal.AbstractType;
import org.apache.cassandra.db.marshal.UTF8Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a test as requiring the defined columnFamily to be present.
 * Comparator and validator are UTF8Type by default.
 * @author zznate
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequiresColumnFamily {
  String ksName();
  String cfName();
  boolean isCounter() default false;
  String comparator() default "UTF8Type";
  String defaultValidator() default "UTF8Type";
  String keyValidator() default "UTF8Type";

  /**
   * Mark as true to truncate the column family before any tests are
   * executed.
   * @return
   */
  boolean truncateExisting() default false;
}
