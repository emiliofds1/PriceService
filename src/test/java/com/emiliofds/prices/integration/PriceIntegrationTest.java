package com.emiliofds.prices.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PriceIntegrationTest {

    private static final String PRICE_ENDPOINT = "/price";
    private static final String PRODUCT_ID = "35455";
    private static final String BRAND_ID = "1";
    private static final String VALID_DATE = "2021-06-14T10:00:00Z";
    private static final String INVALID_PRODUCT_ID = "99999";
    private static final String OUT_OF_RANGE_DATE = "2019-01-01T00:00:00Z";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPrice_givenNoProductID_shouldReturnsBadRequest() throws Exception {
        performPriceRequest(null, BRAND_ID, VALID_DATE)
                .andExpect(status().isBadRequest());
    }

    @Test
    void getPrice_givenNoBrandID_shouldReturnsBadRequest() throws Exception {
        performPriceRequest(PRODUCT_ID, null, VALID_DATE)
                .andExpect(status().isBadRequest());
    }

    @Test
    void getPrice_givenNoDate_shouldReturnsBadRequest() throws Exception {
        performPriceRequest(PRODUCT_ID, BRAND_ID, null)
                .andExpect(status().isBadRequest());
    }

    @Test
    void getPrice_givenInvalidParameters_shouldReturnsNotFound() throws Exception {
        performPriceRequest(INVALID_PRODUCT_ID, BRAND_ID, VALID_DATE)
                .andExpect(status().isNotFound());
    }

    @Test
    void whenDateOutOfRange_thenReturnsNotFound() throws Exception {
        performPriceRequest(PRODUCT_ID, BRAND_ID, OUT_OF_RANGE_DATE)
                .andExpect(status().isNotFound());
    }

    @Test
    void whenPriceValueIsInvalid_thenReturnsBadRequest() throws Exception {
        performPriceRequest("2", "1", VALID_DATE)
                .andExpect(status().isInternalServerError());
    }

    @Test
    void whenMultiplePricesWithSamePriority_thenReturnsInternalServerError() throws Exception {
        performPriceRequest("3", "1", VALID_DATE)
                .andExpect(status().isInternalServerError());
    }

    @Test
    void getPrice_test1_shouldReturnPriceList1() throws Exception {
        performPriceRequest(PRODUCT_ID, BRAND_ID, "2020-06-14T10:00:00Z")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(Integer.parseInt(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId").value(Integer.parseInt(BRAND_ID)))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void getPrice_test2_shouldReturnPriceList2() throws Exception {
        performPriceRequest(PRODUCT_ID, BRAND_ID, "2020-06-14T16:00:00Z")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(Integer.parseInt(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId").value(Integer.parseInt(BRAND_ID)))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    void getPrice_test3_shouldReturnPriceList1() throws Exception {
        performPriceRequest(PRODUCT_ID, BRAND_ID, "2020-06-14T21:00:00Z")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(Integer.parseInt(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId").value(Integer.parseInt(BRAND_ID)))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void getPrice_test4_shouldReturnPriceList3() throws Exception {
        performPriceRequest(PRODUCT_ID, BRAND_ID, "2020-06-15T10:00:00Z")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(Integer.parseInt(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId").value(Integer.parseInt(BRAND_ID)))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    void getPrice_test5_shouldReturnPriceList4() throws Exception {
        performPriceRequest(PRODUCT_ID, BRAND_ID, "2020-06-16T21:00:00Z")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95));
    }

    private ResultActions performPriceRequest(String productId, String brandId, String date) throws Exception {
        MockHttpServletRequestBuilder request = get(PRICE_ENDPOINT);

        addParamIfNotNull(request, "productId", productId);
        addParamIfNotNull(request, "brandId", brandId);
        addParamIfNotNull(request, "date", date);

        return mockMvc.perform(request);
    }

    private void addParamIfNotNull(MockHttpServletRequestBuilder request, String paramName, String paramValue) {
        if (paramValue != null) {
            request.param(paramName, paramValue);
        }
    }

}
