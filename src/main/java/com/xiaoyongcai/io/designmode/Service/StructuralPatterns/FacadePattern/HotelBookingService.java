package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.FacadePattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HotelBookingService {
    public String bookHotel(String hotelDetails) {
        log.info(hotelDetails);
        return "Hotel booked: " + hotelDetails;
    }
}