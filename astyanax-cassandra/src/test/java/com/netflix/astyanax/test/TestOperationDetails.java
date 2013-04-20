package com.netflix.astyanax.test;

import java.util.List;
import com.netflix.astyanax.serializers.*;
import com.netflix.astyanax.test.CasTestCommon.SchemaType;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.Serializer;
/*
 * @author Shyam Singh
 */

public class TestOperationDetails <S,K,CN> {
	private String keyspace;
	private String cfName;
	private List<ComparatorType>	keyTypes;
	private List<ComparatorType>    colTypes;
	private Serializer<S>			serializer;
	private TestOperations<S,K,CN>  testOperations;
	private SchemaType 			schemaType;
	public TestOperationDetails(final String keyspace, final String cfName, final List<ComparatorType> keyTypes, final List<ComparatorType> colTypes, final Serializer<S> serializer, final SchemaType schemaType) {
		this.setKeyspace(keyspace);
		this.setKeyTypes(keyTypes);
		this.setCfName(cfName);
		this.setColTypes(colTypes);
		this.setSerializer(serializer);
		this.setSchemaType(schemaType);
	}
	public List<ComparatorType> getKeyTypes() {
		return keyTypes;
	}
	public void setKeyTypes(List<ComparatorType> keyTypes) {
		this.keyTypes = keyTypes;
	}
	public String getKeyspace() {
		return keyspace;
	}
	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}
	public List<ComparatorType> getColTypes() {
		return colTypes;
	}
	public void setColTypes(List<ComparatorType> colTypes) {
		this.colTypes = colTypes;
	}
	public Serializer<S> getSerializer() {
		return serializer;
	}
	public void setSerializer(Serializer<S> serializer) {
		this.serializer = serializer;
	}
	public TestOperations<S,K,CN> getTestOperations() {
		return testOperations;
	}
	public void setTestOperations(TestOperations<S,K,CN> testOperations) {
		this.testOperations = testOperations;
	}
	public SchemaType getSchemaType() {
		return schemaType;
	}
	public void setSchemaType(SchemaType schemaType) {
		this.schemaType = schemaType;
	}
    public String getCfName() {
        return cfName;
    }
    public void setCfName(String cfName) {
        this.cfName = cfName;
    }
}
