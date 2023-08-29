package com.example.easybookkeepingsystem.interfaces.bookkeeping;

import com.example.easybookkeepingsystem.common.constants.DateTimeConstants;
import com.example.easybookkeepingsystem.common.mapper.OrderMapper;
import com.example.easybookkeepingsystem.domain.order.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookkeepingResponse {

    List<Bookkeeping> list;

    public static BookkeepingResponse of(List<Order> orders) {
        List<Bookkeeping> list = orders.stream().map(OrderMapper.INSTANCE::toBookkeepingResponse).toList();
        return new BookkeepingResponse(list);
    }

    @Builder
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static class Bookkeeping {
        Long orderId;
        Long orderVersion;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.PATTERN_yyyyMMddHHmmss, timezone = DateTimeConstants.KST)
        Instant orderDate;
        Long partnerId;
        Long partnerVersion;
        String partnerName;
        BigDecimal price;
        String note;
    }
}
