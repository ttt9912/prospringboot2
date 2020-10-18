package rsocket.integrationclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// serialization
@Data
@AllArgsConstructor
@NoArgsConstructor
class GreetingResponse {
    String message;
}