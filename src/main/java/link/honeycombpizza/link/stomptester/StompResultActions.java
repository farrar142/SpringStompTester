package link.honeycombpizza.link.stomptester;


import link.honeycombpizza.link.stomptester.results.StompResultHandler;
import link.honeycombpizza.link.stomptester.results.StompResultMatcher;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;


public class StompResultActions<T>{
    private final CompletableFuture<T> future;
    private final Integer timeout;
    public StompResultActions(CompletableFuture<T> future, Integer timeout){
        this.future = future;
        this.timeout = timeout;
    }
    public StompResultActions<T> andDo(StompResultHandler handler) throws ExecutionException, InterruptedException, TimeoutException {
        handler.apply(this);
        return this;
    }

    public StompResultActions<T> andExpect(StompResultMatcher<T> handler) throws ExecutionException, InterruptedException, TimeoutException {
        handler.apply(this);
        return this;
    }
    public T andReturn() throws ExecutionException, InterruptedException, TimeoutException {
        return this.future.get(this.timeout, TimeUnit.SECONDS);
    }
    public T andReturn(Integer timeout) throws ExecutionException, InterruptedException, TimeoutException {
        return this.future.get(timeout, TimeUnit.SECONDS);
    }
//    public StompResultActions<T> andAssert(Function<>)
}

