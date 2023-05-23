package org.example.service;

import org.example.model.Report;
import org.example.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private final OrderService orderService;

    @Autowired
    public ReportService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Report generateReport() {
        List<Sale> sales = orderService.getSalesByProduct();

        // Lógica adicional para generar el informe

        Report report = new Report();
        report.setSales(sales);

        return report;
    }
}