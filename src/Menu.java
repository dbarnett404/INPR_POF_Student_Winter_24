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

    public void showMenu(Students students ) {

    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Students students = new Students();
        students.addStudentsFromFile();
        menu.showMenu(students);
    }
}
