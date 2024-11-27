package com.xiaoyongcai.io.designmode.pojo.StructuralPatterns.FacadePattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelRequest {
    //航班细节
    private String flightDetails;
    //酒店细节
    private String hotelDetails;
    //订票细节
    private String ticketDetails;
}
