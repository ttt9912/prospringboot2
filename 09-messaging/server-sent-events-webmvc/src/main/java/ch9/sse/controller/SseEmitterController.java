package ch9.sse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Non-Blocking Request:
 * - returns an event every second
 *
 * Fontend -> EventSource
 */
@RestController
@RequestMapping("/sse-emitter")
public class SseEmitterController {
    private final ExecutorService nonBlockingExecutor = Executors.newSingleThreadExecutor();

    @GetMapping("/stream-sse-mvc")
    public SseEmitter streamSseMvc() {
        SseEmitter emitter = new SseEmitter();

        nonBlockingExecutor.execute(() -> {
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
        return emitter;
    }
}
