package com.example.easybookkeepingsystem.application;

import com.example.easybookkeepingsystem.domain.order.Order;

import java.util.List;

public interface LoadBookkeepingUseCase {

    List<Order> getBookkeepingList(long companyId, int year, int month);

}
