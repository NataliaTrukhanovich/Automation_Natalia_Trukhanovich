package pageObjects.moodpanda.entity;

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
            System.out.println("New instance from constructor "+signUpBuilder+" ");
        }
        public Builder withFirstName(String firstName) {
            System.out.println("firstName");
            signUpBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            System.out.println("lastName");
            signUpBuilder.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            System.out.println("mail");
            signUpBuilder.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            System.out.println("passssword");
            signUpBuilder.password = password;
            return this;
        }

        public Builder withCheckbox(Boolean checkbox) {
            System.out.println("checkbox");
            signUpBuilder.checkbox = checkbox;
            return this;
        }
        public SignUpBuilder build(){
            System.out.println("Method build");
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
