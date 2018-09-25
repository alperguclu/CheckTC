package com.alperguclu.checktc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.alperguclu.checktc.resources.ObjectFactory;
import com.alperguclu.checktc.resources.TCKimlikNoDogrula;
import com.alperguclu.checktc.resources.TCKimlikNoDogrulaResponse;

@Component
public class Client {

  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  @Autowired
  private WebServiceTemplate webServiceTemplate;

  public Boolean check(String name, String surname, int yearOfBirth, long tc) {
    ObjectFactory factory = new ObjectFactory();
    TCKimlikNoDogrula query = factory.createTCKimlikNoDogrula();

    query.setAd(name);
    query.setSoyad(surname);
    query.setDogumYili(yearOfBirth);
    query.setTCKimlikNo(tc);
    
    LOGGER.info("Client sending query with parameters: ", query.getAd(), query.getSoyad(), query.getDogumYili(), query.getTCKimlikNo());

    TCKimlikNoDogrulaResponse response = (TCKimlikNoDogrulaResponse) webServiceTemplate.marshalSendAndReceive(query, new SoapActionCallback("http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula"));
    Boolean result = response.isTCKimlikNoDogrulaResult();

    LOGGER.info("Client received result as ", result);
    
    return result;
  }
}
