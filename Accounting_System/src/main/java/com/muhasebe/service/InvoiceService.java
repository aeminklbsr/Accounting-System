package com.muhasebe.service;

import com.muhasebe.model.Customer;
import com.muhasebe.model.Invoice;
import com.muhasebe.repository.CustomerRepository;
import com.muhasebe.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Invoice createInvoice(Invoice invoice) {
        // Verilen müşteri kimliği ile müşteriyi veritabanından bulun
        Customer customer = customerRepository.findById(invoice.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı"));

        // Faturaya mevcut müşteri nesnesini ayarla
        invoice.setCustomer(customer);

        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Fatura bulunamadı"));
    }

    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Invoice invoice = getInvoiceById(id);
        invoice.setAmount(invoiceDetails.getAmount());
        invoice.setDate(invoiceDetails.getDate());
        invoice.setDescription(invoiceDetails.getDescription());
        invoice.setDueDate(invoiceDetails.getDueDate());
        invoice.setIssueDate(invoiceDetails.getIssueDate());

        // Müşteri güncellemesi yapılacaksa mevcut müşteri veritabanından tekrar yüklenir
        if (invoiceDetails.getCustomer() != null) {
            Customer customer = customerRepository.findById(invoiceDetails.getCustomer().getId())
                    .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı"));
            invoice.setCustomer(customer);
        }

        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    public List<Invoice> listAllInvoices() {
        return invoiceRepository.findAll();
    }
}
