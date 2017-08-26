package manas.concurrency.executor.pojo;

public class ResponseContext {

    private Object response;

    private Class type;

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
