package link.honeycombpizza.link.stomptester.results;


import link.honeycombpizza.link.stomptester.StompResultActions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface StompResultHandler {
    <T> void apply(StompResultActions<T> actions) throws ExecutionException, InterruptedException, TimeoutException;
}
