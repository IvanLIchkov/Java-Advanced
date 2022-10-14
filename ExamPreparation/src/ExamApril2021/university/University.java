package ExamApril2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
    public int getStudentCount(){
        return this.students.size();
    }
    public String registerStudent(Student student){
        if (this.students.size()<capacity){
            if (!students.contains(student)){
                students.add(student);
                return  "Added student "+student.getFirstName()+" "+student.getLastName();
            }else{
                return "Student is already in the university";
            }
        }else{
            return "No seats in the university";
        }
    }
    public String dismissStudent(Student student){
        if (students.removeIf(s->s.equals(student))){
            return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
        }
            return "Student not found";
    }
    public Student getStudent(String firstName,String lastName){
        return students.stream()
                .filter(s->s.getFirstName().equals(firstName)&&s.getLastName().equals(lastName))
                .findAny()
                .orElse(null);
    }
    public String getStatistics(){
        StringBuilder output=new StringBuilder();
        for (Student student : students) {
            output.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",student.getFirstName(),student.getLastName(),student.getBestSubject())).append(System.lineSeparator());
        }
        return String.valueOf(output);
    }
}
