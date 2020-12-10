package org.jaimediaz1991.phonechallenge.orders.controller;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.jaimediaz1991.phonechallenge.orders.service.JsonConverter;
import org.jaimediaz1991.phonechallenge.orders.service.OrderServiceImpl;
import org.jaimediaz1991.phonechallenge.orders.validator.ValidatorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

  @RunWith(SpringRunner.class)
  @WebMvcTest(OrderController.class)
  @AutoConfigureMockMvc
  public class OrderControllerTest {

    public static final String PHONES_URL = "/orders";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderServiceImpl orderService;
    @MockBean
    private JsonConverter jsonConverter;
    @MockBean
    private ValidatorServiceImpl validator;

    @Test
    public void requestInvalidBodyShouldReturnBadRequestStatus() throws Exception {
      this.mockMvc.perform(post(PHONES_URL)).andDo(print()).andExpect(status().isBadRequest())
          .andExpect(content().string(containsString("")));
    }

    @Test
    public void requestInvalidPhoneIdsShouldReturnBadRequestStatus() throws Exception {

      when(validator.validatePhoneList(anyList())).thenReturn(false);
      String bodyRequest = "{\"costumerName\": \"JAIME\","
          + "    \"costumerSurname\": \"DIAZ\","
          + "    \"costumerEmail\": \"email\","
          + "    \"orderPhoneIds\": ["
          + "        \"2\",\"1\",\"3\""
          + "    ]"
          + "}";
      this.mockMvc.perform(post(PHONES_URL).content(bodyRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isBadRequest())
          .andExpect(content().string(containsString("")));
    }
    @Test
    public void requestValidOrderRequestShouldReturnOkStatus() throws Exception {
      when(validator.validatePhoneList(anyList())).thenReturn(true);
      String bodyRequest = "{\"costumerName\": \"JAIME\","
          + "    \"costumerSurname\": \"DIAZ\","
          + "    \"costumerEmail\": \"email\","
          + "    \"orderPhoneIds\": ["
          + "        \"2\",\"1\",\"3\""
          + "    ]"
          + "}";
      this.mockMvc.perform(post(PHONES_URL).content(bodyRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
          .andExpect(content().string(containsString("")));
    }
  }