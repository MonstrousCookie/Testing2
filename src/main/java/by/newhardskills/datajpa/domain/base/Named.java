package by.newhardskills.datajpa.domain.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Named extends Identifiable {

    @Column(name = "name", columnDefinition = "varchar(255)")
    @JsonProperty
    protected String name;

    public Named(String name, long id) {
        super(id);
        this.name = name;
    }

}
