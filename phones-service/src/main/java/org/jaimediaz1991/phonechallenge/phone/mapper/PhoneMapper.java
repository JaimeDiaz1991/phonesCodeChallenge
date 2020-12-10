package org.jaimediaz1991.phonechallenge.phone.mapper;

import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.commons.model.entity.Phone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

  PhoneResponse modelToResponseDto(Phone phone);
}
