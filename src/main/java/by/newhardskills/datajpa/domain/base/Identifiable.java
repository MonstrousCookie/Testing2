package by.newhardskills.datajpa.domain.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@MappedSuperclass
public abstract class Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    @JsonProperty
    protected long id;

    public Identifiable(long id) {
        this.id = id;
    }

}
