package Lecture14.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(builderMethodName = "HomeBuilder", buildMethodName = "create", setterPrefix = "with")
@Getter
@ToString
public class Home {
    String doors;
    String color;
    String address;
    Integer winCount;
    Boolean old;

    public static class HomeBuilder

    {
        public HomeBuilder() {
    }
    }
}
