package manas.concurrency.forkjoin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class WordProcessor extends RecursiveTask<String> {

    private final String str;
    private static int THRESH_HOLD =1;

    public WordProcessor(String str){
        this.str = str;
    }

    protected String compute() {
        String []words = str.split(" ");
        StringBuilder builder = new StringBuilder();
        if(words.length > THRESH_HOLD){
            Collection<WordProcessor> dividedTask =  ForkJoinTask.invokeAll(createSubTasks(words));
            for(WordProcessor task : dividedTask){
                builder.append(task.join());
            }
        }
        return str.toUpperCase();
    }

    private Collection<WordProcessor> createSubTasks(String []words) {
        List<WordProcessor> tasks = new ArrayList<>();
        for(String word : words ){
            WordProcessor smallTask = new WordProcessor(word);
            tasks.add(smallTask);
        }
        return tasks;
    }
}
