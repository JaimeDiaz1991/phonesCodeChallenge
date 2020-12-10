package org.jaimediaz1991.phonechallenge.phone.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.commons.model.entity.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhoneMapperTest {

  PhoneMapper phoneMapper = Mappers.getMapper(PhoneMapper.class);

  @Test
  public void testing(){
    String id = "1";
    String name= "phone one";
    String image = "imageRefOne";
    String description ="smartphoneOne";
    Double price = 25.56;
    Phone phone = new Phone(id,name,image,description,price);
    PhoneResponse phoneResponse = phoneMapper.modelToResponseDto(phone);
    assertThat(phoneResponse, notNullValue());
    assertThat(phoneResponse.getId(), is(id));
    assertThat(phoneResponse.getName(), is(name));
    assertThat(phoneResponse.getDescription(), is(description));
    assertThat(phoneResponse.getImage(), is(image));
    assertThat(phoneResponse.getPrice(), is(BigDecimal.valueOf(price)));

  }
}
