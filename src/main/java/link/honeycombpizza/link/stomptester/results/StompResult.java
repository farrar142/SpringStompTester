package link.honeycombpizza.link.stomptester.results;


import link.honeycombpizza.link.stomptester.StompResultActions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class StompResult {
    public static <T> StompResultMatcher<T> isEqualTo(T expectedValue) {
        return new StompResultMatcher<T>() {
            @Override
            public StompResultMatcher<T> apply(StompResultActions<T> actions) throws ExecutionException, InterruptedException, TimeoutException {
                if (actions == null) {
                    throw new AssertionError("StompResultActions cannot be null");
                }
                if (expectedValue == null) {
                    throw new AssertionError("Expected value cannot be null");
                }
                if (!actions.andReturn().equals(expectedValue)){
                    throw new AssertionError("Expected " + expectedValue + " but got " + actions.andReturn());
                }
                return this;
            }
        };
    }
    public static StompResultHandler print(){
        return new StompResultHandler() {
            @Override
            public <T> void apply(StompResultActions<T> actions) throws ExecutionException, InterruptedException, TimeoutException {
                System.out.println(actions.andReturn());
            }
        };
    }

    public static <T> StompResultMatcher<T> isReceived(Integer timeout){
        return new StompResultMatcher<T>() {
            @Override
            public StompResultMatcher<T> apply(StompResultActions<T> actions) throws ExecutionException, InterruptedException, TimeoutException {
                if (actions == null) {
                    throw new AssertionError("StompResultActions cannot be null");
                }
                if (actions.andReturn(timeout) == null) {
                    throw new AssertionError("Expected a non-null value, but got null");
                }
                return this;
            }
        };
    }

}

