package com.project.test.crud.service;

import com.project.test.crud.dao.StudentDao;
import com.project.test.crud.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    /*public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    public ResponseEntity<Student> saveStudent(Student student) {
        student = studentDao.save(student);

        if(student.getStudentId()==null){
            throw new RuntimeException("Student save Request failed");
        }else{
            return ResponseEntity.ok(student);
        }
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentDao.findAll();
        return ResponseEntity.ok(studentList);
    }

    public ResponseEntity<Student> getStudentById(Long studentId) {
        if(studentId==null){
            throw new RuntimeException("Student id is required");
        }else{
            //"Optional" is used to check that the student is available or not in the database. return true or false
            Optional<Student> optStudent = studentDao.findById(studentId);
            if(optStudent.isPresent()){
                return ResponseEntity.ok(optStudent.get());//here we can't use optStudent directly bcz it returns
                //Optional value not a Student value. so we use optStudent.get() to get the student.
            }else{
                throw new RuntimeException("Data not found for given student Id");
            }
        }
    }

    public ResponseEntity<Student> updateStudent(Long studentId, Student student) {
        if(studentId==null){
            throw new RuntimeException("Student id is required");
        }else{
            Optional<Student> optStudent = studentDao.findById(studentId);
            if(optStudent.isPresent()){
                Student studentUpdateObj = optStudent.get();
                studentUpdateObj.setFirstName(student.getFirstName());
                studentUpdateObj.setLastName(student.getLastName());
                studentUpdateObj.setGrade(student.getGrade());
                studentUpdateObj.setAddress(student.getAddress());

                studentUpdateObj=studentDao.save(studentUpdateObj);
                return ResponseEntity.ok(studentUpdateObj);
            }else{
                throw new RuntimeException("Data not found for given student Id");
            }
        }
    }

    public ResponseEntity<String> deleteStudent(Long studentId) {
        if(studentId==null){
            throw new RuntimeException("Student id is required");
        }else{
            Optional<Student> optStudent = studentDao.findById(studentId);
            if(optStudent.isPresent()){
                studentDao.deleteById(studentId);


                return ResponseEntity.ok("Student deleted");
            }else{
                throw new RuntimeException("Data not found for given student Id");
            }
        }
    }
}
