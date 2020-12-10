package org.jaimediaz1991.phonechallenge.phone.controller;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import org.jaimediaz1991.phonechallenge.commons.model.dto.PhoneResponse;
import org.jaimediaz1991.phonechallenge.phone.service.PhoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PhoneController.class)
@AutoConfigureMockMvc
public class PhoneControllerTest {

  public static final String PHONES_URL = "/phones";
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private PhoneService service;

  @Test
  public void shouldReturnEmptyPhoneList() throws Exception {
    this.mockMvc.perform(get(PHONES_URL)).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("[]")));
  }

  @Test
  public void shouldReturnEmptyOnePhone() throws Exception {
    when(service.findAll()).thenReturn(Arrays.asList(new PhoneResponse("1","phoneNAme","refImage","smartphone 3g",
        BigDecimal.valueOf(50L))));
    this.mockMvc.perform(get("/phones")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("[{\"id\":\"1\",\"name\":\"phoneNAme\",\"image\":\"refImage\",\"description\":\"smartphone 3g\",\"price\":50}]")));
  }
}
