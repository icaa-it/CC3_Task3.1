import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/studentprofile?serverTimezone=Asia/Manila";
    private final String USER = "root";
    private final String PASS = "Prettyme_3";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void saveStudent(Student s) throws SQLException {
        String sql = "INSERT INTO userInput (firstName, lastName, age, gender, address, course, yearLevel, phoneNumber) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getAddress());
            ps.setString(6, s.getCourse());
            ps.setInt(7, s.getYearLevel());
            ps.setString(8, s.getPhoneNumber());
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM userInput";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(new Student.Builder()
                        .setStudentId(rs.getInt("studentID"))
                        .setFirstName(rs.getString("firstName"))
                        .setLastName(rs.getString("lastName"))
                        .setAge(rs.getInt("age"))
                        .setGender(rs.getString("gender"))
                        .setAddress(rs.getString("address"))
                        .setCourse(rs.getString("course"))
                        .setYearLevel(rs.getInt("yearLevel"))
                        .setPhoneNumber(rs.getString("phoneNumber"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}