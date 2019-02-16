package reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.data.ToDo;

import java.util.List;

/*
 * Flux<T> - is a Publisher<T>
 * - represents an async sequence of 0-N items
 * - optionally terminates with onComplete() or onError()
 *
 * EmitterProcessor - synchronous processor (async: WorkQueueProcessor, TopicProcessor)
 * acts as publisher, creates a flux of items
 * - onNext() emits an item
 * - onComplete() finishes the upstream
 */
public class FluxExample {

    @Test
    void fluxExample() {
        final EmitterProcessor<ToDo> stream = EmitterProcessor.create();

        Mono<List<ToDo>> promise = stream
                .filter(ToDo::getCompleted)
                .doOnNext(toDo -> System.out.printf("Mono >> %s", toDo.getDescription()))
                .collectList()
                .subscribeOn(Schedulers.single());

        stream.onNext(new ToDo("feed dog", true));
        stream.onNext(new ToDo("go walk", false));
        stream.onNext(new ToDo("read book", false));

        stream.onComplete();
        promise.block();
    }
}
