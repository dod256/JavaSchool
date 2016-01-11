package chuggaChugga.controller;

import chuggaChugga.data.TicketForReport;
import chuggaChugga.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/api/report")
    public List<TicketForReport> getTickets() {
        //ToDo complete
        //return ticketService.getTicketsReport();
        return null;
    }

}
