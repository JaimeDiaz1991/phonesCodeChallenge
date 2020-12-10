package org.jaimediaz1991.phonechallenge.orders.validator;

import java.util.List;
import org.jaimediaz1991.phonechallenge.orders.service.OrderService;
import org.jaimediaz1991.phonechallenge.orders.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    @Autowired
    private OrderService orderService;

    public boolean validatePhoneList(final List<String> phoneIds) {
        return orderService.obtainAvailablePhones().keySet().containsAll(phoneIds);
    }
}
