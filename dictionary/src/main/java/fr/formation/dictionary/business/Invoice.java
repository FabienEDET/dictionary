package fr.formation.dictionary.business;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

//import org.springframework.web.bind.annotation.GetMapping;
public class Invoice {

    private Long id;

    @NotEmpty
    private String reference;

    @PastOrPresent
    private LocalDate date;

    private double amount;

    private boolean paid = false;

    public boolean isPaid() {
	return paid;
    }

    public void setPaid(boolean paid) {
	this.paid = paid;
    }

    public Invoice(String reference, LocalDate date, double amount) {
	this.reference = reference;
	this.date = date;
	this.amount = amount;
    }
    /*
     * public listInvoice(String reference) { this.reference = reference; }
     */

    // les fonctions getter/setter permettent d'affecter des valeurs à des
    // variables créées en "private" et donc inaccessibles directement
    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return "{id=" + id + ", reference=" + reference + ", date=" + date
		+ ", amount=" + amount + ", paid=" + paid + "}";
    }
}
