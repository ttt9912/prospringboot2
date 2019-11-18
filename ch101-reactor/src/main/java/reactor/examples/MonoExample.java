package reactor.examples;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoProcessor;
import reactor.core.scheduler.Schedulers;
import reactor.examples.data.ToDo;

import java.time.Duration;

/*
 * Mono<T> - is a Publisher<T>
 * - emits one item
 * - can apply operations to manipulate the item
 * - terminates with onComplete() or onError()
 *
 * MonoProcessor - processor is both publisher and subscriber
 * one can subscribe to a processor but also inject items
 * - onNext() emits an item
 *
 * Scheduler - subscribeOn(Scheduler) - subscribes to the mono
 * and requests unbounded demand on a Scheduler worker
 *
 * block() - subscribes to the Mono and blocks until a next
 * item is received or timeout expires
 */
public class MonoExample {

    @Test
    void monoExample() {
        final MonoProcessor<ToDo> promise = MonoProcessor.create();

        Mono<ToDo> result = promise
                .doOnSuccess(toDo -> System.out.printf("Mono >> %s", toDo.getDescription()))
                .doOnTerminate(() -> System.out.println("Mono >> done"))
                .doOnError(throwable -> System.out.printf("Error >> %s", throwable.getMessage()))
                .subscribeOn(Schedulers.single());

        promise.onNext(new ToDo("feed dog", false));

        result.block(Duration.ofMillis(1000));
    }
}
