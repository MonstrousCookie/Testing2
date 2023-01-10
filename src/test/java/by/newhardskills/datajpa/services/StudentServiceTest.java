package by.newhardskills.datajpa.services;

import by.newhardskills.datajpa.domain.entities.Student;
import by.newhardskills.datajpa.repositories.StudentRepository;
import by.newhardskills.datajpa.services.impl.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
public class StudentServiceTest {

    private static final String ACTUAL_STUDENT_FILE = "src/test/resources/services/data/student.json";

    private static final String ACTUAL_STUDENTS_FILE = "src/test/resources/services/data/students.json";

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void countOfAllStudentsEquals4Test() {
        Mockito.when(studentService.getCountOfAllStudents()).thenReturn(4L);

        Assertions.assertEquals(4, studentService.getCountOfAllStudents());
    }

    @Test
    public void getAllStudents1StudentTest() throws IOException {
        Student expected = new Student(1L, "Nikolay", 4.6);

        Mockito.when(studentRepository.findAll()).thenReturn(List.of(expected));

        Assertions.assertTrue(assertEqualsToFile(expected, ACTUAL_STUDENT_FILE));
    }

    private boolean assertEqualsToFile(Student student, final String filename) throws IOException {
        return student.equals(readFromFile(filename));
    }

    private Student readFromFile(final String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(filename).toFile(), Student.class);
    }


    public static class StudentGroup {

        List<Student> students;

        public StudentGroup(List<Student> students) {
            this.students = students;
        }

    }

}
