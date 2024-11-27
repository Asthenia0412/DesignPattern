package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.FacadePattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FlightBookingService {
    public String bookFlight(String flightDetails) {
        log.info(flightDetails);
        return "Flight booked: " + flightDetails;
    }
}