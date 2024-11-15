import java.util.ArrayList;
import java.util.Scanner;
public class studentManager {
    private ArrayList<student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void addStudent() {
        while (true) {
            try {
                System.out.print("Enter Student ID: ");
                int id = 0;
                boolean validId = false;
                while (!validId) {
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                        validId = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter numeric values for ID.");
                        System.out.print("Enter Student ID: ");
                    }
                }
                String name = "";
                while (true) {
                    System.out.print("Enter Student Name: ");
                    name = scanner.nextLine().trim();
                    if (name.matches("[a-zA-Z ]+")) {
                        break;
                    } else {
                        System.out.println("Invalid input! Please enter a valid name containing only letters and spaces.");
                    }
                }
                double marks = 0;
                while (true) {
                    System.out.print("Enter Student Marks: ");
                    try {
                        marks = Double.parseDouble(scanner.nextLine());
                        if (marks >= 0 && marks <= 10) {
                            break;
                        } else {
                            System.out.println("Invalid input! Marks should be between 0 and 10.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter numeric values for Marks.");
                    }
                }
                students.add(new student(id, name, marks));
                break;
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
    public void editStudent() {
        System.out.print("Enter Student ID to edit: ");
        int id = 0;
        boolean validId = false;
        while (!validId) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                validId = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values for ID.");
                System.out.print("Enter Student ID to edit: ");
            }
        }
        student student = findStudentById(id);
        if (student != null) {
            System.out.println("Editing student: " + student);
            String name = "";
            while (true) {
                System.out.print("Enter new name: ");
                name = scanner.nextLine().trim();
                if (name.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a valid name containing only letters and spaces.");
                }
            }
            double marks = 0;
            while (true) {
                System.out.print("Enter new marks: ");
                try {
                    marks = Double.parseDouble(scanner.nextLine());
                    if (marks >= 0 && marks <= 10) {
                        break;
                    } else {
                        System.out.println("Invalid input! Marks should be between 0 and 10.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter numeric values for Marks.");
                }
            }
            student.setName(name);
            student.setMarks(marks);
            student.updateRank();

            System.out.println("Student updated: " + student);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted: " + student);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
    public void searchStudentById() {
        System.out.print("Enter Student ID to search: ");
        int id = Integer.parseInt(scanner.nextLine());

        student student = findStudentById(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
    public void searchStudentByName() {
        System.out.print("Enter Student Name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found: " + student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            students.forEach(System.out::println);
        }
    }
    public void sortStudentsByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("Students sorted by marks:");
        displayStudents();
    }
    private student findStudentById(int id) {
        for (student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
