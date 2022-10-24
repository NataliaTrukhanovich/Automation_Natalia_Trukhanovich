package Lecture14.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(builderMethodName = "SBuilder", buildMethodName = "create", setterPrefix = "with")
@Getter
@ToString
public class SaucedemoBuilderLombok {
    String login;
    String password;

    public static class SBuilder
    {
        public SBuilder() {
        }
    }

}
