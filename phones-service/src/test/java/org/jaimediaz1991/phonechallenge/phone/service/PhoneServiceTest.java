package org.jaimediaz1991.phonechallenge.phone.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.commons.model.entity.Phone;
import org.jaimediaz1991.phonechallenge.phone.mapper.PhoneMapper;
import org.jaimediaz1991.phonechallenge.phone.model.dao.PhoneDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceTest {

  @Mock
  PhoneDao phoneDao;
  @Mock
  PhoneMapper phoneMapper;
  @Mock
  PhoneResponse phone;

  @InjectMocks
  PhoneServiceImpl phoneService;

  @Test
  public void whenDataBasePhoneIsEmptyShouldReturnEmptyList(){
    when(phoneDao.findAll()).thenReturn(Collections.emptyList());
    assertThat(phoneService.findAll().size(),is(0));
  }
  @Test
  public void whenDataBaseConatinsOnePhoneShouldReturnOneListWithOnePhone(){
    when(phoneDao.findAll()).thenReturn(Arrays.asList(new Phone()));
    when(phoneMapper.modelToResponseDto(any())).thenReturn(phone);
    assertThat(phoneService.findAll().size(),is(1));
  }

}
