package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
//permet d'indiquer à spring que cette clase désigne un controleur
@RequestMapping("/invoices")
// indiquer au serveur que pour les requêtes topées "dummy", elles devront passer par ce controleur
public class InvoiceController {

    @GetMapping("/{id}")
    public Invoice invoice(@PathVariable("id") Long id) {
	LocalDate date = LocalDate.of(1985, 06, 11);
	Invoice invoice = new Invoice("A01", date, 1005.36);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public ArrayList<Invoice> listInvoice(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size=" + size + ", page=" + page);
	LocalDate date = LocalDate.of(2019, 12, 31);
	ArrayList<Invoice> listInvoice = new ArrayList<>();
	Invoice first = new Invoice("A02", date, 44);
	listInvoice.add(first);
	Invoice second = new Invoice("A03", date, 55);
	listInvoice.add(second);
	return listInvoice;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id " + id);
    }
    // on simule la suppression des factures

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody Invoice invoice) {
	System.out.println(invoice);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("Unpaid invoice with id " + id);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Paid invoice with id " + id);
    }
}
