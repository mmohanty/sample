package manas.concurrency.executor;

import manas.concurrency.executor.pojo.ResponseContext;

public interface MessageReader<T extends Number> {
    ResponseContext readMessage(T length);
}
