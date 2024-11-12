import java.util.ArrayList;
import java.util.HashSet;

public class Students {
    private ArrayList<Student> students;

    private HashSet<Student> studentSet;

    /**
     * Constructor for the Students class
     */
    public Students() {
        students = new ArrayList<>();

        studentSet = new HashSet<>();
    }

    /**
     * Adds a student to the list
     * @param studentData a CSV String of the relevant student data to add
     */
    public void add(String studentData){
        students.add(new Student(studentData));
    }

    /**
     * Adds a student to the list uses polymorphism
     * @param student the student to add
     */
    public void add(Student student) {
        students.add(student);
    }

    /**
     * Returns a list of students as a list of strings
     * @return the aan Array List of students
     */
    public ArrayList<String> getStudentList() {
        ArrayList<String> register = new ArrayList<>();
        for (Student student : students) {
            register.add(student.toString());
        }
        return register;
    }

    /**
     * Reads the list of students from a CSV file
     */
    public void addStudentsFromFile()  {
        try {
            ArrayList<String> studentList = FileIO.readDataFromFile(FileIO.DATA_FILE);
            for (String studentData : studentList) {
                add(studentData);
            }
        } catch (FileIOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prints the list of students
     */
    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Complete the method to search for a student by name or partial name
     * @param name - the name or partial name to search for
     * @return the student if found, null otherwise - extension task if more than one match return all matches
     */
    public Student searchStudentByName(String name) {

        return null;
    }

    /**
     * Saves the current list of students to a CSV file
     */
    public void saveStudentsToFile() {
        try {
            FileIO.writeDataToFile(FileIO.DATA_FILE, this);
        } catch (FileIOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Complete a method that selects a random student from the list with no repeats
     * Once all students have been selected - print out a message to say that all students have been
     * selected and start selecting again. Use any logical mechanism to achieve this.
     * @return the random student
     */
    public Student getRandomStudentNoRepeats() {
        return null;
    }
}
