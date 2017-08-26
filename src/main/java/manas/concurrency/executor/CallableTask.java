package manas.concurrency.executor;

import manas.concurrency.executor.pojo.RequestContext;
import manas.concurrency.executor.pojo.ResponseContext;

import java.util.concurrent.Callable;

public class CallableTask<I extends RequestContext> implements Callable<ResponseContext>{

    private I input;

    public CallableTask(I input){
        this.input = input;
    }

    @Override
    public ResponseContext call() throws Exception {
        MessageReader service = input.getService();
        return service.readMessage(input.getInput());
    }
}
