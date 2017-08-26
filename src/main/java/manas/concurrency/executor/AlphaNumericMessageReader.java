package manas.concurrency.executor;

import manas.concurrency.executor.pojo.ResponseContext;
import org.apache.commons.lang3.RandomStringUtils;

public class AlphaNumericMessageReader implements MessageReader<Integer>{

    @Override
    public ResponseContext readMessage(Integer length) {
        String response =  RandomStringUtils.randomAlphanumeric(length);
        ResponseContext context = new ResponseContext();
        context.setResponse(response);
        context.setType(String.class);
        return context;
    }

}
