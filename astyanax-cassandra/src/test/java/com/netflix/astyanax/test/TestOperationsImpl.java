package com.netflix.astyanax.test;

import java.util.List;

import com.netflix.astyanax.test.CasTestCommon.SchemaType;

public class TestOperationsImpl<S,K,CN> implements TestOperations<S,K,CN> {

	@Override
	public void createSchema(TestOperationDetails oi) {
		// TODO Auto-generated method stub		
	}

	@Override
	public List writeEntries(TestOperationDetails oi, int rows, int columns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRows(TestOperationDetails oi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countRowColumns(TestOperationDetails oi) {
		// TODO Auto-generated method stub
		return 0;
	}
	public  TestOperations<S,K,CN> getOperationsImpl(SchemaType type) {
		if (type.equals(SchemaType.UUIDSTRING)) {
			
		}
		return null;		
	}
}
