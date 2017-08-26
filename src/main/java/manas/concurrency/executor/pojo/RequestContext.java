package manas.concurrency.executor.pojo;

import manas.concurrency.executor.MessageReader;

public class RequestContext<I extends Number, S extends MessageReader> {

    private I input;
    private S service;

    public I getInput() {
        return input;
    }

    public void setInput(I input) {
        this.input = input;
    }

    public S getService() {
        return service;
    }

    public void setService(S service) {
        this.service = service;
    }
}
