package com.avenuecode.personal.databaseservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="userSequence")
    @SequenceGenerator(name="userSequence", initialValue=1, allocationSize=1)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "dt_updating", nullable = false)
    private LocalDateTime dateUpdating;

    @Column(name = "dt_exclusion")
    private LocalDateTime dateExclusion;

//    @ManyToOne
//    private List<Residence> residences;
}
