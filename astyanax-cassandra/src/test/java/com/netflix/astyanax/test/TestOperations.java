package com.netflix.astyanax.test;
/*
 * @author Shyam Singh
 * 
 */

import java.util.List;

public interface TestOperations <S,K,CN>{
	public void createSchema(TestOperationDetails<S,K,CN> oi);
	public List<K> writeEntries(TestOperationDetails<S,K,CN> oi, int rows, int columns);
	public int countRows(TestOperationDetails<S,K,CN> oi);
	public int countRowColumns(TestOperationDetails<S,K,CN> oi);
}
