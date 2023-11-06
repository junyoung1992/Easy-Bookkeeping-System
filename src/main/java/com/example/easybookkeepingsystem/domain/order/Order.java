package com.example.easybookkeepingsystem.domain.order;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Order {
    Long orderId;
    Long orderVersion;
    Instant orderDate;
    Long partnerId;
    Long partnerVersion;
    String partnerName;
    BigDecimal price;
    String note;
}
