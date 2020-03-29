package ch9.sse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * ExecutorService alternatives:
 * - CompleteableFutures
 * - @Async
 *
 * Blocking Request:
 * Request returns !after! complete() is called (takes 5s then returns all events together).
 *
 * Fontend -> Promise
 *
 */
@Slf4j
@RestController
@RequestMapping("/responsebody-emitter")
public class ResponseBodyEmitterController {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    @GetMapping("/rbe")
    public ResponseEntity<ResponseBodyEmitter> handleRbe() {
        log.info("Received request");

        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        executor.execute(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    emitter.send("SSE MVC - " + LocalTime.now().toString());
                    Thread.sleep(1000);
                }
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });

        return new ResponseEntity<>(emitter, HttpStatus.OK);
    }
}
