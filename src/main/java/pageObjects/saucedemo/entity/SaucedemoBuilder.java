package pageObjects.saucedemo.entity;

public class SaucedemoBuilder {
    private String login;
    private String password;

    public static class Builder{
        SaucedemoBuilder saucedemoBuilder;

        public Builder(){
            saucedemoBuilder = new SaucedemoBuilder();
        }

        public Builder withLogin(String login){
            saucedemoBuilder.login = login;
            return this;
        }
        public Builder withPassword(String password){
            saucedemoBuilder.password=password;
            return this;
        }

        public SaucedemoBuilder build(){
            return saucedemoBuilder;
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
