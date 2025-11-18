package link.honeycombpizza.stomptester.results;


import link.honeycombpizza.stomptester.StompResultActions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface StompResultMatcher<T> {
    StompResultMatcher<T> apply(StompResultActions<T> actions) throws ExecutionException, InterruptedException, TimeoutException;
}
