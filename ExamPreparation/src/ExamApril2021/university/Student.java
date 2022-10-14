package ExamApril2021.university;

public class Student {
    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String secondName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBestSubject() {
        return bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, %s", this.firstName, this.lastName, this.bestSubject);
    }
}
