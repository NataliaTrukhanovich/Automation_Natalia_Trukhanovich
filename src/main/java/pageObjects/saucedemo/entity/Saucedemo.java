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
    String firstName;
    String lastName;
    String zipName;

    public static class SaucedemoBuilder {
        public SaucedemoBuilder() {
        }
    }
}
