package ch9.sse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.time.LocalTime;

/*
 * StreamingResponseBody - write directly to an OutputStream
 * before passing that written information back to the client using a ResponseEntity
 *
 * Fontend -> Promise
 */
@RestController
@RequestMapping("/streaming-responsebody")
public class StreamingResponseBodyController {

    @GetMapping("/srb")
    public ResponseEntity<StreamingResponseBody> handleRbe() {
        StreamingResponseBody stream = out -> {
            String msg = "SSE MVC - " + LocalTime.now().toString();
            out.write(msg.getBytes());
        };
        return new ResponseEntity<>(stream, HttpStatus.OK);
    }
}
