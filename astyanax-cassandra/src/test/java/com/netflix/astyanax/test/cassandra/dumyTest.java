package com.netflix.astyanax.test.cassandra;

import static com.netflix.astyanax.core.querybuilder.QueryBuilder.insertInto;

import java.util.Iterator;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.log.Log;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.core.querybuilder.Query;
import com.netflix.astyanax.cql.CqlStatementResult;
import com.netflix.astyanax.model.Column;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.model.ColumnList;
import com.netflix.astyanax.model.Row;
import com.netflix.astyanax.model.Rows;
import com.netflix.astyanax.serializers.StringSerializer;
import com.netflix.astyanax.serializers.UUIDSerializer;
import org.apache.cassandra.db.marshal.UUIDType;

@RunWith(CassandraRunner.class)
@RequiresKeyspace(ksName = "myks")
@RequiresColumnFamily(ksName = "myks", cfName = "uuidtest", comparator = "org.apache.cassandra.db.marshal.UTF8Type", keyValidator = "org.apache.cassandra.db.marshal.UUIDType")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class dumyTest {
    @Test
    public void mytest2() {
        int i = 0;
        System.out.println("Hello World!");
    }
//    private static AstyanaxContext<Keyspace> keyspaceContext;
//    public static Keyspace keyspace = keyspaceContext.getEntity();
//    static ColumnFamily<UUID, String> UUID_CF = ColumnFamily.newColumnFamily(
//            "uuidtest", UUIDSerializer.get(), StringSerializer.get());
//    @Test
//    public void myTest() throws Exception{
//        final UUID id = UUID.randomUUID();
//        final String given = "John";
//        final String surname = "Doe";
//        keyspace.prepareCqlStatement()
//                .withCql(
//                        "CREATE TABLE uuidtest (id UUID PRIMARY KEY, given text, surname text);")
//                .execute();
//        Query insert;
//        insert = insertInto("uuidtest").value("id", id).value("given", given)
//                .value("surname", surname);
//        Log.info("==========" + insert.toString() + "============");
//        Assert.assertEquals("INSERT INTO uuidtest(id,given,surname) VALUES ("
//                + id.toString() + ",'" + given + "','" + surname + "');",
//                insert.toString());
//        keyspace.prepareCqlStatement().withCql(insert.toString()).execute();
//        CqlStatementResult result = keyspace.prepareCqlStatement()
//                .withCql("SELECT * FROM uuidtest ;").execute().getResult();
//
//        Rows<UUID, String> rows = result.getRows(UUID_CF);
//        Iterator<Row<UUID, String>> iter = rows.iterator();
//        while (iter.hasNext()) {
//            Row<UUID, String> row = iter.next();
//            ColumnList<String> cols = row.getColumns();
//            Iterator<Column<String>> colIter = cols.iterator();
//            while (colIter.hasNext()) {
//                Column<String> col = colIter.next();
//                String name = col.getName();
//                Log.info("*************************************");
//                if (name.equals("id")) {
//                    UUID val = col.getValue(UUIDSerializer.get());
//                    Log.info("columnname=  " + name + "  columnvalue= " + val);
//                    Assert.assertEquals(id.toString(), val.toString());
//                }
//                if (name.equals("given")) {
//                    String val = col.getValue(StringSerializer.get());
//                    Log.info("columnname=  " + name + "  columnvalue= "
//                            + val.toString());
//                    Assert.assertEquals(given, val);
//                }
//                if (name.equals("surname")) {
//                    String val = col.getValue(StringSerializer.get());
//                    Log.info("columnname=  " + name + "  columnvalue= " + val);
//                    Assert.assertEquals(surname, val);
//                }
//            }
//            Log.info("*************************************");
//        }
//        Assert.assertEquals(1, rows.size());
//    }

}
