package org.jaimediaz1991.phonechallenge.phone.service;

import java.util.List;
import java.util.stream.Collectors;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.commons.model.entity.Phone;
import org.jaimediaz1991.phonechallenge.phone.mapper.PhoneMapper;
import org.jaimediaz1991.phonechallenge.phone.model.dao.PhoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDao phoneDao;
    @Autowired
    private PhoneMapper phoneMapper;


    @Override
    @Transactional(readOnly = true)
    public List<PhoneResponse> findAll() {
        return ((List<Phone>)phoneDao.findAll()).stream().map(phone -> phoneMapper.modelToResponseDto(phone)).collect(
            Collectors.toList());
    }

}
