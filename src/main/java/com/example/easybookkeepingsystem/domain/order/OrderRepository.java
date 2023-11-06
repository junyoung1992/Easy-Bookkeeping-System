package com.example.easybookkeepingsystem.domain.order;

import com.example.easybookkeepingsystem.common.mapper.OrderMapper;
import com.example.easybookkeepingsystem.infrastructure.persistence.order.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public List<Order> findAllByCompanyIdAndOrderDateBetweenOrderByOrderDateDesc(long companyId, Instant startDateTime, Instant endDateTime) {
        return orderJpaRepository.findAllByCompanyIdAndOrderDateBetween(companyId, startDateTime, endDateTime).stream()
                .map(OrderMapper.INSTANCE::fromOrderEntity)
                .sorted(Comparator.comparing(Order::getOrderDate, Comparator.reverseOrder()))
                .toList();
    }

}
