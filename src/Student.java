public class Student {
    private final int studentID;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String gender;
    private final String address;
    private final String course;
    private final int yearLevel;
    private final String phoneNumber;

    private Student(Builder builder) {
        this.studentID = builder.studentID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.gender = builder.gender;
        this.address = builder.address;
        this.course = builder.course;
        this.yearLevel = builder.yearLevel;
        this.phoneNumber = builder.phoneNumber;
    }

    // Getters
    public int getStudentId() { return studentID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getCourse() { return course; }
    public int getYearLevel() { return yearLevel; }
    public String getPhoneNumber() { return phoneNumber; }

    public static class Builder {
        private int studentID;
        private String firstName;
        private String lastName;
        private int age;
        private String gender;
        private String address;
        private String course;
        private int yearLevel;
        private String phoneNumber;

        public Builder setStudentId(int studentID) { this.studentID = studentID; return this; }
        public Builder setFirstName(String firstName) { this.firstName = firstName; return this; }
        public Builder setLastName(String lastName) { this.lastName = lastName; return this; }
        public Builder setAge(int age) { this.age = age; return this; }
        public Builder setGender(String gender) { this.gender = gender; return this; }
        public Builder setAddress(String address) { this.address = address; return this; }
        public Builder setCourse(String course) { this.course = course; return this; }
        public Builder setYearLevel(int yearLevel) { this.yearLevel = yearLevel; return this; }
        public Builder setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }

        public Student build() { return new Student(this); }
    }
}