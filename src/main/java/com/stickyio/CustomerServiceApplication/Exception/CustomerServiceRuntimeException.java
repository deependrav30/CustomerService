package com.stickyio.CustomerServiceApplication.Exception;

import org.apache.kafka.common.protocol.types.Field;

public class CustomerServiceRuntimeException extends RuntimeException{
    public CustomerServiceRuntimeException(String message)
    {
        super("CustomerServiceRuntimeException occurred: "+message);
    }
}
