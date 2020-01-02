package de.ceanstudios.sparkadvanced.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdvancedResponse {

    private int state;
    private String message;
    private Object body;

    public static AdvancedResponse ok() {
        return ok(null);
    }

    public static AdvancedResponse ok(Object object) {
        return AdvancedResponse.builder()
                .state(200)
                .message("Success")
                .body(object)
                .build();
    }

    public static AdvancedResponse failed(int state, String message) {
        return AdvancedResponse.builder()
                .state(state)
                .message(message)
                .build();
    }

}
