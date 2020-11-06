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
//@Getter
//@Setter
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateUpdating() {
        return dateUpdating;
    }

    public void setDateUpdating(LocalDateTime dateUpdating) {
        this.dateUpdating = dateUpdating;
    }

    public LocalDate getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(LocalDate paymentDay) {
        this.paymentDay = paymentDay;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public UserEntity getPayingUser() {
        return payingUser;
    }

    public void setPayingUser(UserEntity payingUser) {
        this.payingUser = payingUser;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }
}
