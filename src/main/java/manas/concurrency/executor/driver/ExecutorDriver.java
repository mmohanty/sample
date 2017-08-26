package manas.concurrency.executor.driver;

import manas.concurrency.executor.AlphaNumericMessageReader;
import manas.concurrency.executor.CallableTask;
import manas.concurrency.executor.StringMessageReader;
import manas.concurrency.executor.pojo.RequestContext;
import manas.concurrency.executor.pojo.ResponseContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDriver {
    public static void main(String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<ResponseContext>> resultList = new ArrayList<>();

        for (int i=1; i<=4; i++)
        {

            CallableTask task;
            if(i % 2 == 0) {
                RequestContext<Integer, AlphaNumericMessageReader> context = new RequestContext();
                context.setInput(Integer.valueOf(i));
                context.setService(new AlphaNumericMessageReader());
                task  = new CallableTask(context);
            }else {

                RequestContext<Integer, StringMessageReader> context = new RequestContext();
                context.setInput(Integer.valueOf(i));
                context.setService(new StringMessageReader());
                task  = new CallableTask(context);
            }

            Future<ResponseContext> result = executor.submit(task);
            resultList.add(result);
        }

        for(Future<ResponseContext> future : resultList)
        {
            try
            {
                ResponseContext responseContext = future.get(1, TimeUnit.MINUTES);
                Object response = responseContext.getType().cast(responseContext.getResponse());
                System.out.println("Future result is - " + " - " + response + "; And Task done is " + future.isDone());
            }
            catch (InterruptedException | ExecutionException | TimeoutException e)
            {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }
}

