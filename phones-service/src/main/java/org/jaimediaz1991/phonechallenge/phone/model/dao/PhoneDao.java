package org.jaimediaz1991.phonechallenge.phone.model.dao;

import org.jaimediaz1991.phonechallenge.commons.model.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneDao extends CrudRepository<Phone, Long> {
}
