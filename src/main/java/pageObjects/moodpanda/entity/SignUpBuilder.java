package pageObjects.moodpanda.entity;

import lombok.extern.log4j.Log4j;

@Log4j
public class SignUpBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean checkbox;

    public static class Builder{
        private SignUpBuilder signUpBuilder;

        public Builder() {
            this.signUpBuilder = new SignUpBuilder();
            log.debug("New instance from constructor "+signUpBuilder+" ");
        }
        public Builder withFirstName(String firstName) {
            log.debug("With firstName");
            signUpBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            log.debug("With lastName");
            signUpBuilder.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            log.debug("With mail");
            signUpBuilder.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            log.debug("With password");
            signUpBuilder.password = password;
            return this;
        }

        public Builder withCheckbox(Boolean checkbox) {
            log.debug("With checkbox");
            signUpBuilder.checkbox = checkbox;
            return this;
        }
        public SignUpBuilder build(){
            log.debug("Running method build");
            return signUpBuilder;
        }
    }
    @Override
    public String toString() {
        return "SignUpBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", checkbox=" + checkbox +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }
}
