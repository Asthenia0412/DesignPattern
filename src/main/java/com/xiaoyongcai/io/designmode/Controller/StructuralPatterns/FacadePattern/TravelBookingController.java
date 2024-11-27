package com.xiaoyongcai.io.designmode.Controller.StructuralPatterns.FacadePattern;

import com.xiaoyongcai.io.designmode.Service.StructuralPatterns.FacadePattern.TravelBookingFacade;
import com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.FacadePattern.TravelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FacadePattern")
public class TravelBookingController {

    @Autowired
    private TravelBookingFacade travelBookingFacade;

    @PostMapping("/book")
    public ResponseEntity<String> bookTrip(@RequestBody TravelRequest request) {
        String result = travelBookingFacade.bookTrip(
                request.getFlightDetails(),
                request.getHotelDetails(),
                request.getTicketDetails()
        );
        return ResponseEntity.ok(result);
    }
}
