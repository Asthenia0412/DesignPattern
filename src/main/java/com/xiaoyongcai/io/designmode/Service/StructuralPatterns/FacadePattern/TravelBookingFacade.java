package com.xiaoyongcai.io.designmode.Service.StructuralPatterns.FacadePattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TravelBookingFacade {

    @Autowired
    private FlightBookingService flightBookingService;

    @Autowired
    private HotelBookingService hotelBookingService;

    @Autowired
    private TicketBookingService ticketBookingService;

    public String bookTrip(String flightDetails, String hotelDetails, String ticketDetails) {
        String flightBooking = flightBookingService.bookFlight(flightDetails);
        String hotelBooking = hotelBookingService.bookHotel(hotelDetails);
        String ticketBooking = ticketBookingService.bookTicket(ticketDetails);
        log.info("[外观模式]:所有的复杂业务代码均已经执行完成,是通过在Facade类中统一调用的，这样客户端屏蔽了复杂的业务实现，通过每个复杂子系统暴露出的接口，完成了复杂任务的调度。");
        return flightBooking + "\n" + hotelBooking + "\n" + ticketBooking;
    }
}
