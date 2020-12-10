package org.jaimediaz1991.phonechallenge.orders.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonConverter<T> {

  @Autowired
  ObjectMapper mapper;

  public String convertToJson(T objectModel ){
    try {
      return mapper.writeValueAsString(objectModel);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

}
