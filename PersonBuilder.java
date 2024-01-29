import java.util.Date;

public class Person {
    // Required attributes
    private final String firstName;
    private final String lastName;

    // Optional attributes
    private String middleName;
    private String[] addresses;
    private String nationality;
    private String religion;
    private Date dateOfBirth;
    private String sex;
    private String countryOfResidency;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.addresses = builder.addresses;
        this.nationality = builder.nationality;
        this.religion = builder.religion;
        this.dateOfBirth = builder.dateOfBirth;
        this.sex = builder.sex;
        this.countryOfResidency = builder.countryOfResidency;
    }

    // Getter methods for attributes

    public static class Builder {
        // Required attributes
        private final String firstName;
        private final String lastName;

        // Optional attributes
        private String middleName;
        private String[] addresses;
        private String nationality;
        private String religion;
        private Date dateOfBirth;
        private String sex;
        private String countryOfResidency;

        // Constructor with required attributes
        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // Setter methods for optional attributes
        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder addresses(String[] addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder religion(String religion) {
            this.religion = religion;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder countryOfResidency(String countryOfResidency) {
            this.countryOfResidency = countryOfResidency;
            return this;
        }

        // Build method to create Person object
        public Person build() {
            return new Person(this);
        }
    }

    // Other methods and functionalities of the Person class
}
