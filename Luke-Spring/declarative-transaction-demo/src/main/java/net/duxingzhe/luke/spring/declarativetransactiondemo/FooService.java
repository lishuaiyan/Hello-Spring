package net.duxingzhe.luke.spring.declarativetransactiondemo;

import java.sql.SQLTransactionRollbackException;

/**
 * @author luke yan
 * @CreateDate 2020/08/28
 */
public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException ;
    void invokeInsertThenRollback() throws RollbackException, SQLTransactionRollbackException;

}
