package i_poo.v_design_patterns.D_OtherPatterns_WEB;

import java.util.ArrayList;
import java.util.List;

public class IV_Data_Acces_Object {
  public static void main(String[] args) {
//======================================================================================================================
//                            4) Use the StudentDao to demonstrate Data Access Object pattern usage.
//======================================================================================================================
    StudentDao studentDao = new StudentDaoImpl();

    //print all students
    for (Studentt student : studentDao.getAllStudents()) {
      System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }

    //update student
    Studentt student = studentDao.getAllStudents().get(0);
    student.setName("Michael");
    studentDao.updateStudent(student);

    //get the student
    studentDao.getStudent(0);
    System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    /*
      Student: [RollNo : 0, Name : Robert ]
      Student: [RollNo : 1, Name : John ]
      Student: Roll No 0, updated in the database
      Student: [RollNo : 0, Name : Michael ]
    */
  }
}

//======================================================================================================================
//                                         Data Access Object Pattern
//======================================================================================================================
/*
Data Access Object Pattern or DAO pattern is used to separate low level data accessing API or operations from
high level business services. Following are the participants in Data Access Object Pattern.

     .Data Access Object Interface - This interface defines the standard operations to be performed on a model object(s).
      ============================

     .Data Access Object concrete class - This class implements above interface. This class is responsible to get data
      ============================        from a data source which can be database / xml or any other storage mechanism.

     .Model Object or Value Object - This object is simple POJO containing get/set methods to store data retrieved
      ============================   using DAO class.
*/
//======================================================================================================================
//                                             Implementation
//======================================================================================================================
/*
We are going to create a Student object acting as a Model or Value Object.StudentDao is Data Access Object
Interface.StudentDaoImpl is concrete class implementing Data Access Object Interface. DaoPatternDemo, our demo class,
will use StudentDao to demonstrate the use of Data Access Object pattern.

                                                  <<Interface>>
      --------------------------           -----------------------------           ------------------------
      |        Student         |           |       StudentDao          |           |         Main         |
      --------------------------    uses   -----------------------------    uses   ------------------------
      | - name : String        |<----------|                           |<----------|                      |
      | - rollNo : int         |           |                           |           | + main() : void      |
      --------------------------           -----------------------------           ------------------------
      | + Student()            |           | + getAllStudents() : List |
      | + getName() : String   |           | + updateStudent() : void  |
      | + setName() : void     |           | + deleteStudent() : void  |
      | + getRollNo() : int    |           | + addStudent() : void     |
      | + setRollNo() : String |           |                           |
      |                        |           -----------------------------
      --------------------------                        /\
                                                        |
                                                        | implements
                                                        |
                                            -----------------------------
                                            |     StudentDaolmpl        |
                                            -----------------------------
                                            |                           |
                                            | - Student : List          |
                                            -----------------------------
                                            | + StudentDaolmpl()        |
                                            | + getAllStudents() : List |
                                            | + updateStudent() : void  |
                                            | + deleteStudent() : void  |
                                            | + addStudent() : void     |
                                            |                           |
                                            -----------------------------
*/
//======================================================================================================================
//                                             1) Create Value Object.
//======================================================================================================================
class Studentt {
  private String name;
  private int rollNo;

  Studentt(String name, int rollNo) {
    this.name = name;
    this.rollNo = rollNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRollNo() {
    return rollNo;
  }

  public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
  }
}

//======================================================================================================================
//                                  2) Create Data Access Object Interface.
//======================================================================================================================
interface StudentDao {
  public List<Studentt> getAllStudents();

  public Studentt getStudent(int rollNo);
  public void updateStudent(Studentt student);
  public void deleteStudent(Studentt student);
}

//======================================================================================================================
//                            3) Create concrete class implementing above interface.
//======================================================================================================================
class StudentDaoImpl implements StudentDao {

  //list is working as a database
  List<Studentt> students;

  public StudentDaoImpl() {
    students = new ArrayList<Studentt>();
    Studentt student1 = new Studentt("Robert", 0);
    Studentt student2 = new Studentt("John", 1);
    students.add(student1);
    students.add(student2);
  }

  @Override
  public void deleteStudent(Studentt student) {
    students.remove(student.getRollNo());
    System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
  }

  //retrive list of students from the database
  @Override
  public List<Studentt> getAllStudents() {
    return students;
  }

  @Override
  public Studentt getStudent(int rollNo) {
    return students.get(rollNo);
  }

  @Override
  public void updateStudent(Studentt student) {
    students.get(student.getRollNo()).setName(student.getName());
    System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
  }
}
