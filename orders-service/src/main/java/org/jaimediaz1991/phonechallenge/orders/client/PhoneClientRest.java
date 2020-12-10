package org.jaimediaz1991.phonechallenge.orders.client;

import java.util.List;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "phones-service")
public interface PhoneClientRest {

    @GetMapping("/phones")
    List<PhoneResponse> findAll();
}
