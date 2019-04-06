package pl.bykowski.springbootjdbcthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Student student) {
        String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]
                {student.getId(),
                 student.getName(),
                 student.getSurname(),
                 student.getFinalGrade()});
    }


    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {

    }


}
