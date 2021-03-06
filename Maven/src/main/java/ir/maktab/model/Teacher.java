package ir.maktab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Mohammad hashemi
 * <p>
 * Teacher entity/Table
 */
@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

    /**
     * Fields or columns
     * <p>
     * data types should be wrapper to enforcing nullability in the database
     */
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "teacher_code", nullable = false, unique = true)
    private Long teacherCode;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * Default constructor
     */
    public Teacher() {

    }

    /**
     * Constructor
     *
     * @param firstName
     * @param lastName
     * @param teacherCode
     * @param salary
     * @param birthday
     */
    public Teacher(String firstName, String lastName, Long teacherCode, Double salary, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherCode = teacherCode;
        this.salary = salary;
        this.birthday = birthday;
    }

    /**
     * Getter and Setter
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(Long teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * ToString because we don't want to see hashCode
     * instead of real data
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode=" + teacherCode +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", address=" + address +
                '}';
    }
}

