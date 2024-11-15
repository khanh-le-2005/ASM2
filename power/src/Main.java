import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        studentManager manager = new studentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Search Student by Name");
            System.out.println("6. Display Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.editStudent();
                    break;
                case 3:
                    manager.deleteStudent();
                    break;
                case 4:
                    manager.searchStudentById();
                    break;
                case 5:
                    manager.searchStudentByName();
                    break;
                case 6:
                    manager.displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 7);
    }
}
