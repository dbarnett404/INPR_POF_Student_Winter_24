/**
 * Complete  the Menu class that displays a menu of options to the user and allows the user to interact with the
 * Students class.
 * Add methods / code to support all the options below.
 * The code should loop until the user chooses to exit.
 */
public class Menu {
    private final String[] menuItems = {
            "Add student",
            "Print students",
            "Save students to file",
            "Load students from file",
            "Select random student with no repeats",
            "Search for student by name",
            "Exit"
    };

    private void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
    }

    private void addStudent(Students students ) {
        String firstName = Input.getString("Enter first name: ");
        String lastName = Input.getString("Enter last name: ");
        int age = Input.getInt("Enter age: ");
        String group = Input.getString("Enter group: ");
        String country = Input.getString("Enter country: ");
        students.add(new Student(firstName, lastName.toUpperCase(), age, group, country));
    }

    public void searchForStudent(Students students) {
        String name = Input.getString("Enter student name or partial name: ");
        System.out.println(students.searchStudentByName(name));
    }

    public void showMenu(Students students ) {
        int choice = 0;
        while (choice != menuItems.length) {
            displayMenu();
            choice = Input.getInt("Enter your choice: ");
            if (choice > 0 && choice < menuItems.length) {
                switch (choice) {
                    case 1:
                        addStudent(students);
                        break;
                    case 2:
                        students.printStudents();
                        break;
                    case 3:
                        students.saveStudentsToFile();
                        break;
                    case 4:
                        students.addStudentsFromFile();
                        break;
                    case 5:
                        System.out.println(students.getRandomStudentNoRepeats());
                        break;
                    case 6:
                        searchForStudent(students);
                        break;
                }
                System.out.println(menuItems[choice - 1]);
            } else if (choice != menuItems.length) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Students students = new Students();
        students.addStudentsFromFile();
        menu.showMenu(students);
    }
}
