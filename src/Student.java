public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String group;

    private String country;
    private String email;

    public Student(String firstName, String lastName, int age, String group, String country, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.country = country;
        this.email = email;
    }

    public Student(String firstName, String lastName, int age, String group, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.country = country;
        email = generateEmail();
    }

    public Student(String studentData) {
        String[] data = studentData.split(",");
        this.firstName = data[0];
        this.lastName = data[1];
        this.age = Integer.parseInt(data[2]);
        this.group = data[3];
        this.country = data[4];
        this.email = data[5];
    }

    /**
     * Complete the method that formats the last name to have the first letter in uppercase if the last name is one word
     * If the last name is two words with a hyphen e.g. el-Sabir, the first letter of the first word should not be upper case
     * , all subsequent words will have the first letter uppercase and the remaining letters lower case
     * @return
     */
    public String formatLastName() {
        return "";
    }
    public String getStudentName() {
        return firstName + " " + formatLastName();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Complete the method to generate a random 'fake' email address for the student in the Sussex format
     * @return
     */
    public String generateEmail() {
        return "";
    }
    @Override
    public String toString() {
        return firstName + "," +
                lastName + "," +
                age + "," +
                group + "," +
                country + "," +
                email;
    }
}
