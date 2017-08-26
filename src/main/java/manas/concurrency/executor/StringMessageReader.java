package manas.concurrency.executor;


import manas.concurrency.executor.pojo.ResponseContext;
import org.apache.commons.lang3.RandomStringUtils;

public class StringMessageReader implements MessageReader<Integer> {

    @Override
    public ResponseContext readMessage(Integer length) {
        String response = RandomStringUtils.randomAlphabetic(length);
        ResponseContext context = new ResponseContext();
        context.setType(String.class);
        context.setResponse(response);
        return context;
    }


}
