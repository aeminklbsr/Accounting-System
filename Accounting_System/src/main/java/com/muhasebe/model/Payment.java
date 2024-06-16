package com.muhasebe.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment extends Transaction {
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    private LocalDate paymentDate;

    // Getters and Setters

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
