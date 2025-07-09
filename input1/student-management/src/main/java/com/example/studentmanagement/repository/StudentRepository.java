import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, marks) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getMarks());
    }

    public Student findStudentById(Long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Student(rs.getLong("id"), rs.getString("name"), rs.getInt("marks")));
    }

    public void deleteStudent(Long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Student> findRankedStudents() {
        String sql = "SELECT * FROM students ORDER BY marks DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(rs.getLong("id"), rs.getString("name"), rs.getInt("marks")));
    }
}