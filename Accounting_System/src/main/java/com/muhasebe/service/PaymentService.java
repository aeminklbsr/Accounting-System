package com.muhasebe.service;

import com.muhasebe.model.Invoice;
import com.muhasebe.model.Payment;
import com.muhasebe.repository.InvoiceRepository;
import com.muhasebe.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Payment createPayment(Payment payment) {
        // İlgili faturayı veritabanından alın
        Invoice invoice = invoiceRepository.findById(payment.getInvoice().getId())
                .orElseThrow(() -> new RuntimeException("Fatura bulunamadı"));

        // Ödeme nesnesine faturayı ayarlayın
        payment.setInvoice(invoice);

        // Transaction alanlarını doğru ayarlayın
        payment.setAmount(payment.getAmount());
        payment.setDate(payment.getDate());
        payment.setDescription(invoice.getDescription());
        payment.setCustomer(invoice.getCustomer());
        payment.setPaymentDate(payment.getPaymentDate()); // PaymentDate ayarlama

        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Ödeme bulunamadı"));
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = getPaymentById(id);
        payment.setAmount(paymentDetails.getAmount());
        payment.setDate(paymentDetails.getDate());
        payment.setPaymentDate(paymentDetails.getPaymentDate()); // PaymentDate ayarlama

        // Fatura güncellemesi yapılacaksa mevcut fatura veritabanından tekrar yüklenir
        if (paymentDetails.getInvoice() != null) {
            Invoice invoice = invoiceRepository.findById(paymentDetails.getInvoice().getId())
                    .orElseThrow(() -> new RuntimeException("Fatura bulunamadı"));
            payment.setInvoice(invoice);
        }

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public List<Payment> listAllPayments() {
        return paymentRepository.findAll();
    }
}
