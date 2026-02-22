import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Repository repo = new Repository();
            boolean running = true;

            while (running) {
                System.out.println("\n===== STUDENT SYSTEM =====");
                System.out.println("[1] Register Student");
                System.out.println("[2] View Master List");
                System.out.println("[3] Exit");
                System.out.print("Choose an option: ");
                
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        registerStudent(scanner, repo);
                        break;
                    case "2":
                        viewMasterList(repo);
                        break;
                    case "3":
                        System.out.println("Exiting program...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void registerStudent(Scanner sc, Repository repo) throws Exception {
        System.out.println("\n--- Register New Student ---");
        
        System.out.print("First Name: ");
        String fName = sc.nextLine();
        System.out.print("Last Name: ");
        String lName = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Gender (M/F): ");
        String gender = sc.nextLine();
        System.out.print("Barangay: ");
        String address = sc.nextLine();
        System.out.print("Program: ");
        String course = sc.nextLine();
        System.out.print("Year Level: ");
        int yearLevel = Integer.parseInt(sc.nextLine());
        System.out.print("Phone Number: ");
        String phone = sc.nextLine();

        // Paggamit ng Builder Pattern
        Student s = new Student.Builder()
                .setFirstName(fName)
                .setLastName(lName)
                .setAge(age)
                .setGender(gender)
                .setAddress(address)
                .setCourse(course)
                .setYearLevel(yearLevel)
                .setPhoneNumber(phone)
                .build();

        repo.saveStudent(s); // Siguraduhin na may executeUpdate() ito sa loob
        System.out.println("\n[SUCCESS] Student registered.");
    }

    private static void viewMasterList(Repository repo) {
        List<Student> students = repo.getAllStudents(); // Kukuha ng fresh data mula sa DB
        
        if (students.isEmpty()) {
            System.out.println("\nNo records found.");
            return;
        }

        System.out.println("\n--- MASTER LIST ---");
        System.out.printf("%-5s | %-15s | %-15s | %-10s%n", "ID", "First Name", "Last Name", "Course");
        System.out.println("------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-5d | %-15s | %-15s | %-10s%n", 
                s.getStudentId(), s.getFirstName(), s.getLastName(), s.getCourse());
        }
    }
}