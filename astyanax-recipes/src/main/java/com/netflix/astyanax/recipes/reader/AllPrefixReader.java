package com.netflix.astyanax.recipes.reader;
import com.google.common.collect.Range;
import com.google.common.collect.Ranges;
/* * Reads all columns in a row that contain the prefixes
 */

import org.apache.cassandra.db.marshal.BytesType;
import org.junit.Test;

import com.netflix.astyanax.model.Composite;

public class AllPrefixReader<K,CN,S> {
    private String keyspace;
    private String cf;
    private K rowkey;
    private CN col;
    public AllPrefixReader(String keyspace, String cf, K rowkey, CN col) {
        this.keyspace = keyspace;
        this.cf = cf;
        this.rowkey = rowkey;
        this.col = col;
    }
    @Test
    public  void test(String[] args) {
//        Composite c = Composite.
        AllPrefixReader<K,CN, S> prefRdr = (AllPrefixReader<K, CN, S>) new AllPrefixReader<String, Composite, BytesType>("testks", "testcf","123",new Composite());
        Range<String> lev0 = Range.closed("A", "~");
        Range<Integer> lev1 = Range.closed(0, 10);
        Range<Integer> lev2 = Range.closed(10, 10);
        Range<Boolean> lev3 = Range.closed(false, true);
        Range<String> lev4 = Range.closed("A", "~");
        
    }

}
