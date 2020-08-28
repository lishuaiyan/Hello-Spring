package net.duxingzhe.luke.spring.errorcodedemo;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author luke yan
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }
    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
