package by.newhardskills.datajpa.domain.entities;

import by.newhardskills.datajpa.domain.base.Named;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student extends Named {

    @Column(name = "average", columnDefinition = "double precision")
    @JsonProperty
    private double average;

    public Student(long id, String name, double average) {
        super(name, id);
        this.average = average;
    }

    public Student() {
        super(null, 0L);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.average, average) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(average);
    }

}
