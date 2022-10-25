package pageObjects.saucedemo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder(buildMethodName = "create", setterPrefix = "with")
@Getter
@ToString
public class Saucedemo {
    String login;
    String password;

    public static class SaucedemoBuilder {
        public SaucedemoBuilder() {
        }
    }
}
