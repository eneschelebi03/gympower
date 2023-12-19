package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.dto.display.DisplayAddressDTO;
import com.example.gympower.model.entity.Address;
import com.example.gympower.model.entity.Order;
import com.example.gympower.model.mapper.AddressMapper;
import com.example.gympower.repository.AddressRepository;
import com.example.gympower.service.AddressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AddressServiceIntegrationTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private AddressMapper addressMapper;

    @InjectMocks
    private AddressService addressService;

    @Test
    public void testSaveAndFindOrdersAddress() {
        // Arrange
        Address addressToSave = new Address();
        Address savedAddress = new Address();
        Order order = new Order();
        order.setAddress(savedAddress);

        DisplayAddressDTO displayAddressDTO = new DisplayAddressDTO();

        // Mocking repository behavior
        when(addressRepository.save(addressToSave)).thenReturn(savedAddress);

        // Mocking mapper behavior
        when(addressMapper.addressToDisplayDTO(savedAddress)).thenReturn(displayAddressDTO);

        // Act
        Address savedAddressResult = addressService.save(addressToSave);
        DisplayAddressDTO displayAddressResult = addressService.findOrdersAddress(order);

        // Assert
        assertEquals(savedAddress, savedAddressResult);
        assertEquals(displayAddressDTO, displayAddressResult);

        // Verify that the save method and findOrdersAddress method were called
        Mockito.verify(addressRepository, Mockito.times(1)).save(addressToSave);
        Mockito.verify(addressMapper, Mockito.times(1)).addressToDisplayDTO(savedAddress);
    }
}
