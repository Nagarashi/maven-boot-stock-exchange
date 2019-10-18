package com.switchfully.maven.exchange.api;

import com.switchfully.maven.exchange.domain.Stock;
import com.switchfully.maven.exchange.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@ResponseBody
@RequestMapping("/stocks")
public class StockExchangeController {

    private StockService stockService;
    //private StockMapper stockMapper;

    @Autowired
    public StockExchangeController(StockService stockService) {
        this.stockService = stockService;
        //this.stockMapper = stockMapper;
    }

    /**
     * For your information:
     * This method gets called from outside this application
     * (not really, but just imagine it will)
     */
    @GetMapping("/{stockId}")
    public StockDto getStock(@PathVariable("stockId") String stockId) {
        Stock foundStock = stockService.getStock(stockId);
        //return stockMapper.mapToDto(foundStock);
        return StockDto.toStockDto(foundStock);
    }

    @GetMapping("/homePage")
    public String getHomePage(){
        return "<html>" +
                "<body style='padding: 10px; text-align: center;'>" +
                "<img src='https://pbs.twimg.com/profile_images/1095310629542551553/TgcAJvMn_400x400.jpg' style='position: absolute; top:12px; left:12px; width: 7.5%;'>" +
                "<div>" +
                "<h1 style='font-size: 64px;'>" +
                "FRIYAY" +
                "</h1>" +
                "<p style='font-size: 50px;'>" + "This means Drinks and Partaaay!" + "</p>" +
                "</div>" +
                "<img src='https://image.shutterstock.com/image-vector/party-time-banner-background-editable-260nw-1068122210.jpg' style='display: block; margin-left: auto; margin-right: auto; width: 85%; height: 45%'>" +
                "<footer>" +"<div>" + "<p style='font-size: 36px';>" + "Sponsored by: Switchfully and Adrien <(^_-)>" + "<p>" + "</div>" + "</footer>" +
                "</body" +
                "</html>";
    }

}
