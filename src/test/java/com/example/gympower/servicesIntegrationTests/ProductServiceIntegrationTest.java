package com.example.gympower.servicesIntegrationTests;
import com.example.gympower.model.dto.display.admin.DisplayAdminProductDTO;
import com.example.gympower.service.ProductService;
import com.example.gympower.service.WearService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @Mock
    private WearService wearService;


    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        // Mocking data
        List<DisplayAdminProductDTO> mockWearList = Collections.singletonList(new DisplayAdminProductDTO());
        when(wearService.getAllWearAdminTable()).thenReturn(mockWearList);

        // Invoke the method
        List<DisplayAdminProductDTO> result = productService.getAllProducts();

        // Verify the result
        assertEquals(mockWearList, result);
    }
}
