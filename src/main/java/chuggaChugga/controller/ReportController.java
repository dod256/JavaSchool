package chuggaChugga.controller;

import chuggaChugga.data.TicketForReport;
import chuggaChugga.service.TicketService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/api/report/{firstDate}/{secondDate}")
    public List<TicketForReport> getTickets(@PathVariable() long firstDate, @PathVariable() long secondDate) {
        System.out.println(new Date(firstDate) + "   " + new Date(secondDate));
        return ticketService.getTicketsReport(new Date(firstDate), new Date(secondDate));
    }

}
