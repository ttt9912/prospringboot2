package rsocket.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// serialization
@Data
@AllArgsConstructor
@NoArgsConstructor
class GreetingRequest {
    String name;
}
