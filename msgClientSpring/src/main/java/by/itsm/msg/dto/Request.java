package by.itsm.msg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@Component
@JsonPropertyOrder({"name", "message"})
public class Request {

    @JsonProperty("name")
    private String name;

    @JsonProperty("message")
    private String message;

    public Request() {
    }

    public Request(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public Request setName(String name) {
        this.name = name;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Request setMessage(String message) {
        this.message = message;
        return this;
    }
}
