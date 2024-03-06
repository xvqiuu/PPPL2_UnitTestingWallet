import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {
    private List<Student> students;

    @BeforeAll
    void initClass() {
        System.out.println("Initializing class");
        students = new ArrayList<>();
    }

    @AfterAll
    void cleanClass() {
        System.out.println("Cleaning class");
        students.clear();
    }

    @BeforeEach
    void initMethod() {
        System.out.println("Initializing method");
        // menambahkan objek student ke list setiap kali sebelum metode pengujian dijalankan
        students.add(new Student("Manawi", 22));
        students.add(new Student("Abi", 20));
        students.add(new Student("Adib", 21));
    }

    @AfterEach
    void cleanMethod() {
        System.out.println("Cleaning method");
        // menghapus semua objek student setiap kali setelah metode pengujian dijalankan
        students.clear();
    }

    @Test
    void testDataCreation() {
        System.out.println("Running testDataCreation");

        // pastikan students tidak null dan memiliki elemen
        Assertions.assertNotNull(students);
        Assertions.assertTrue(students.size() > 0);
    }

    @Test
    void testStudentEnrolment() {
        System.out.println("Running testStudentEnrolment");

        // memastikan student berhasil terdaftar pada kursus tertentu
        Student student = students.get(0);
        student.enrollCourse("Metopen");
        student.enrollCourse("Verval");
        Assertions.assertTrue(student.getEnrolledCourses().contains("Metopen"));
    }

    @Test
    void testStudentGrade() {
        System.out.println("Running testStudentGrade");

        // memastikan student memiliki nilai tertentu untuk kursus tertentu
        Student student = students.get(0);
        student.setGrade("Metopen", "A");
        student.setGrade("Verval","B");
        Assertions.assertEquals("B", student.getGrade("Verval"));
    }
}




