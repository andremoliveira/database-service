package com.avenuecode.personal.databaseservice.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bill")
@Getter
@Setter
@ToString
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="billSequence")
    @SequenceGenerator(name="billSequence", initialValue=1, allocationSize=1)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(name = "dt_creation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "dt_updating", nullable = false)
    private LocalDateTime dateUpdating;

    @Column(name = "payment_day")
    private LocalDate paymentDay;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "paying_user")
    private UserEntity payingUser;

    @ManyToOne
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;
}
