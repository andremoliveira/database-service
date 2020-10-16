package com.avenuecode.personal.databaseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "residence")
@Getter
@Setter
@ToString
public class Residence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="residenceSequence")
    @SequenceGenerator(name="residenceSequence", initialValue=1, allocationSize=1)
    private Long id;

    @Column(nullable = false)
    private String name;

//    @OneToOne
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private String address;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "dt_updating", nullable = false)
    private LocalDateTime dateUpdating;

    @Column(name = "dt_exclusion")
    private LocalDateTime dateExclusion;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_residence",
            joinColumns = @JoinColumn(name = "residence_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
//    @JsonIgnore
    private Set<UserEntity> users;

}
