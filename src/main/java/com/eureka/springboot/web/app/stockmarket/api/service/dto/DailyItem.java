package com.eureka.springboot.web.app.stockmarket.api.service.dto;

import lombok.Data;

@Data
public class DailyItem {
    private String open;
    private String high;
    private String low;
    private String close;

}
