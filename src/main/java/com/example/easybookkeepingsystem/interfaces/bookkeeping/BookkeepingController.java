package com.example.easybookkeepingsystem.interfaces.bookkeeping;

import com.example.easybookkeepingsystem.application.LoadBookkeepingUseCase;
import com.example.easybookkeepingsystem.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/bookkeeping")
@RequiredArgsConstructor
public class BookkeepingController {

    private final LoadBookkeepingUseCase loadBookkeepingUseCase;

    @GetMapping("/list")
    public BookkeepingResponse getBookkeepingList(@RequestParam long companyId, @RequestParam int year, @RequestParam int month) {
        List<Order> orders = loadBookkeepingUseCase.getBookkeepingList(companyId, year, month);
        return BookkeepingResponse.of(orders);
    }

}
