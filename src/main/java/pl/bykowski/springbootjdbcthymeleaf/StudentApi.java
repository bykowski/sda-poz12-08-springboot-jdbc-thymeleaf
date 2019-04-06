package pl.bykowski.springbootjdbcthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentApi {

    private StudentDao studentDao;

    @Autowired
    public StudentApi(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        studentDao.save(student);
    }
}
