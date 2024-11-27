    package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.FacadePattern;

    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;

    @Service
    @Slf4j
    public class TicketBookingService {
        public String bookTicket(String ticketDetails) {
            log.info(ticketDetails);
            return "Ticket booked: " + ticketDetails;
        }
    }
