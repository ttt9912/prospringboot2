package ch9.echosendtouser.endpoint;

import ch9.echosendtouser.data.EchoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/*
 * -------------------------------------------------
 * /queue
 * -------------------------------------------------
 * Convention: Use /queue/ instead of /topic/ to target a specific user
 *
 * Client subscribes to: /user/queue/echo
 *
 * Server Sends to: /user/{username}/queue/position-updates
 * user destination is handled by UserDestinationMessageHandler
 *
 * /user/{username}/queue/position-updates, which in turn is translated by the UserDestinationMessageHandler into one or more destinations, one for each session associated with the user
 *
 * -------------------------------------------------
 * @SendToUser
 * -------------------------------------------------
 * If the user has more than one session, by default, all of the
 * sessions subscribed to the given destination are targeted.
 *
 * To target only the session that sent the message - set broadcast=false
 *
 */
@Slf4j
@Controller
public class EchoController {


    @MessageMapping("/echo") // listen to /app/echo
    @SendToUser("/queue/echo") // send to /user/{username}/queue/echo
    public EchoMessage handle(final EchoMessage echoMessage, final Principal principal) {
        log.info(">>> received from user {} - {}", principal.getName(), echoMessage);
        return echoMessage;
    }
}
