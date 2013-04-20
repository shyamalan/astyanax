package com.netflix.astyanax.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.netflix.astyanax.Serializer;
import com.netflix.astyanax.serializers.ComparatorType;
import com.netflix.astyanax.serializers.StringSerializer;

public class AstyanaxCasTests extends CasTestCommon {
    Logger logger = Logger.getLogger(CasTestCommon.class);
    private static final String keyspace = "ASTYANAX_TEST";
    
    public Logger getLogger() {
        return logger;
    }
    public void setup() {
        super.setUp();
        
    }
    public void teardown() {
        super.teardown();
    }
    @Test
    public void testKSCreation() throws Exception {
        
    }
    @Test
    public void testCFCreation() throws Exception {
        
    }
    @Test
    public void testInsertionAll() throws Exception {
        testInsertion(SchemaType.UUIDSTRING);
        testInsertion(SchemaType.STRINGSTRING);
        testInsertion(SchemaType.STRINGLONG);
        //so on and so forth        
    }
    @Test
    public void testQuery() throws Exception {
        
    }
    private <S,K,CN>void testInsertion(SchemaType type) throws Exception {
        TestOperationDetails<S,K,CN> tod = getTODetails(type);
    }
    private <S,K,CN> TestOperationDetails  getTODetails(SchemaType type) {
        String cfName = type.name()+"_test";
        List<ComparatorType> keyTypes = new ArrayList<ComparatorType>();
        List<ComparatorType> colTypes = new ArrayList<ComparatorType>();
        if (type.equals(SchemaType.STRINGLONG)) {
            keyTypes.add(ComparatorType.UTF8TYPE);
            colTypes.add(ComparatorType.LONGTYPE);
            return new TestOperationDetails<S,K,CN>(keyspace,cfName,keyTypes,colTypes,(Serializer<S>) StringSerializer.get(), type);
        } else if (type.equals(SchemaType.STRINGSTRING)) {
            keyTypes.add(ComparatorType.UTF8TYPE);
            colTypes.add(ComparatorType.UTF8TYPE);
            return new TestOperationDetails<S,K,CN>(keyspace,cfName,keyTypes,colTypes,(Serializer<S>) StringSerializer.get(), type);
        }
        return null;
        
    }
}
