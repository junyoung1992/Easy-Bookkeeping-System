package com.example.easybookkeepingsystem.application.impl;

import com.example.easybookkeepingsystem.application.LoadBookkeepingUseCase;
import com.example.easybookkeepingsystem.common.constants.DateTimeConstants;
import com.example.easybookkeepingsystem.domain.order.Order;
import com.example.easybookkeepingsystem.domain.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements LoadBookkeepingUseCase {

    private final OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getBookkeepingList(long companyId, int year, int month) {
        return orderRepository.findAllByCompanyIdAndOrderDateBetweenOrderByOrderDateDesc(
                companyId,
                ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, DateTimeConstants.ZONE_ID_KST).toInstant(),
                ZonedDateTime.of(year, month + 1, 1, 0, 0, 0, 0, DateTimeConstants.ZONE_ID_KST).toInstant().minusNanos(1));
    }

}
