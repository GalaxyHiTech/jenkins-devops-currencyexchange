package com.ms.currencyexchange.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import com.ms.currencyexchange.resources.CurrencyExchangeController;
import com.ms.currencyexchange.resources.ExchangeValue;
import com.ms.currencyexchange.resources.ExchangeValueRepository;
import com.ms.currencyexchange.util.environment.InstanceInformationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(CurrencyExchangeController.class)
public class CurrencyExchangeControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ExchangeValueRepository repository;

    @MockBean
    private InstanceInformationService instanceInformationService;

    @Test
    public void imHealthy() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void retrieveExchangeValue() throws Exception {
        Mockito.when(repository.findByFromAndTo("EUR", "INR")).thenReturn(new ExchangeValue(Long.getLong("1"), "EUR", "INR", BigDecimal.valueOf(80.00)));
        mvc.perform(get("/currency-exchange/from/EUR/to/INR")).andExpect(status().isOk());
    }
}