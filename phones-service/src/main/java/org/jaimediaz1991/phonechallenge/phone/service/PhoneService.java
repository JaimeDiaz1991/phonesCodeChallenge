package org.jaimediaz1991.phonechallenge.phone.service;

import java.util.List;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;

public interface PhoneService {

    List<PhoneResponse> findAll();
}
