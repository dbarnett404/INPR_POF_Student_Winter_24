import java.util.ArrayList;
import java.util.HashSet;

public class Students {
    private ArrayList<Student> students;

    private HashSet<Student> studentSet;

    public Students() {
        students = new ArrayList<>();

        studentSet = new HashSet<>();
    }
    public void add(String studentData){
        students.add(new Student(studentData));
    }

    public void add(Student student) {
        students.add(student);
    }

    public ArrayList<String> getStudentList() {
        ArrayList<String> register = new ArrayList<>();
        for (Student student : students) {
            register.add(student.toString());
        }
        return register;
    }
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

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Comlete the method to search for a student by name or partial name
     * @param name
     * @return
     */

    public Student searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                return student;
            }
        }
        return null;
    }


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
        if (studentSet.size() == students.size()) {
            System.out.println("All students have been selected. Resetting the set.");
            studentSet.clear();
        }
        int randomIndex = (int) (Math.random() * students.size());

        while (studentSet.contains(students.get(randomIndex))) {
            randomIndex = (int) (Math.random() * students.size());
        }
        studentSet.add(students.get(randomIndex));
        return students.get(randomIndex);
    }

    public int getNumStudents() {
        return students.size();
    }

    public static void main(String[] args) {
        Students students = new Students();
        students.addStudentsFromFile();
        students.printStudents();
        for (int i = 0; i < students.getNumStudents() + 1; i++) {
            System.out.println("Random student " + students.getRandomStudentNoRepeats().getStudentName());
        }
    }
}
