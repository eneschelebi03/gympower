package com.example.gympower.servicesIntegrationTests;

import com.example.gympower.model.dto.display.DisplayUserDTO;
import com.example.gympower.model.dto.display.admin.DisplayUserTableDTO;
import com.example.gympower.model.dto.logic.EditCartDTO;
import com.example.gympower.model.dto.display.DisplayCartItemDTO;
import com.example.gympower.model.dto.logic.RegisterDTO;
import com.example.gympower.model.entity.CartItem;
import com.example.gympower.model.entity.UserEntity;
import com.example.gympower.model.entity.UserRole;
import com.example.gympower.model.entity.enums.UserRolesEnum;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.model.mapper.UserMapper;
import com.example.gympower.repository.UserRepository;
import com.example.gympower.repository.UserRoleRepository;
import com.example.gympower.service.AppUserDetailService;
import com.example.gympower.service.CartItemService;
import com.example.gympower.service.UserService;
import com.example.gympower.service.WearService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceIntegrationTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private WearService wearService;

    @Mock
    private CartItemService cartItemService;

    @Mock
    private ProductMapper productMapper;


    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRoleRepository userRoleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AppUserDetailService userDetailsService;

    @InjectMocks
    private UserService userService;

    @Test
    public void testManipulateCartAdd() throws Exception {
        // Mocking data
        String userEmail = "user@example.com";
        EditCartDTO cartDTO = new EditCartDTO().setWearId(1L).setColor("Red").setSize("M").setQuantity(2);

        UserEntity mockUser = new UserEntity().setEmail(userEmail).setCartItems(new ArrayList<>());
        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(mockUser));

        when(wearService.findWear(cartDTO.getWearId())).thenReturn(new Wear());

        CartItem mockCartItem = new CartItem();
        when(cartItemService.add(any(CartItem.class))).thenReturn(mockCartItem);

        when(productMapper.cartItemToCartDTO(mockCartItem)).thenReturn(new DisplayCartItemDTO());

        // Invoke the method
        String result = userService.manipulateCart(userEmail, cartDTO, "add");

        // Verify the result
        assertEquals(userEmail + " -> " + cartDTO.getWearId(), result);
        verify(userRepository, times(1)).save(mockUser);
    }

    @Test
    public void testManipulateCartRemove() throws Exception {
        // Mocking data
        String userEmail = "user@example.com";
        EditCartDTO cartDTO = new EditCartDTO().setWearId(1L).setColor("Red").setSize("M").setQuantity(2);

        CartItem mockCartItem = new CartItem();
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(mockCartItem);
        UserEntity mockUser = new UserEntity().setEmail(userEmail).setCartItems(cartItems);
        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(mockUser));

        when(cartItemService.findById(cartDTO.getWearId())).thenReturn(mockCartItem);

        // Invoke the method
        String result = userService.manipulateCart(userEmail, cartDTO, "remove");

        // Verify the result
        assertEquals(userEmail + " -> " + cartDTO.getWearId(), result);
        verify(userRepository, times(1)).save(mockUser);
        verify(cartItemService, times(1)).remove(mockCartItem);
    }

    @Test
    public void testFindByEmail() {
        UserEntity userEntity = new UserEntity().setEmail("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(userEntity));

        UserEntity result = userService.findByEmail("test@example.com");

        assertEquals(userEntity, result);
    }

    @Test
    public void testGetCart() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setCartItems(new ArrayList<>());

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(userEntity));

        List<DisplayCartItemDTO> result = userService.getCart("test@example.com");

        assertEquals(0, result.size());
    }

    @Test
    public void testRegisterAndLogin() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setEmail("test@example.com");
        registerDTO.setPassword("password");

        UserEntity newUser = new UserEntity();
        newUser.setEmail("test@example.com");
        newUser.setUsername("sashko");
        newUser.setPassword("encodedPassword");

        UserRole roleUser = new UserRole().setRole(UserRolesEnum.USER);
        newUser.getUserRoles().add(roleUser);

        when(userRoleRepository.findByRole(UserRolesEnum.USER)).thenReturn(roleUser);
        when(userMapper.registerDTOToUser(registerDTO)).thenReturn(newUser);
        when(userDetailsService.loadUserByUsername(any(String.class))).thenReturn(User.builder()
                .username(newUser.getUsername())
                .password(newUser.getPassword())
                .authorities(newUser.getRoles().stream()
                        .map(this::mapRole)
                        .toList())
                .build());
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(userRepository.save(any(UserEntity.class))).thenReturn(newUser);

        List<String> result = userService.registerAndLogin(registerDTO);

        assertEquals(1, result.size());
        assertEquals("ROLE_USER", result.get(0));
    }

    private GrantedAuthority mapRole(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" + userRole.getRole().name());
    }

    @Test
    public void testLogin() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@example.com");
        userEntity.setUsername("sashko");
        userEntity.setPassword("encodedPassword");

        UserRole roleUser = new UserRole().setRole(UserRolesEnum.USER);
        userEntity.getUserRoles().add(roleUser);

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(userEntity));
        when(userDetailsService.loadUserByUsername(any(String.class))).thenReturn(User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream()
                        .map(this::mapRole)
                        .toList())
                .build());

        List<String> result = userService.login("test@example.com");

        assertEquals(1, result.size());
        assertEquals("ROLE_USER", result.get(0));
    }

    @Test
    public void testSave() {
        UserEntity userEntity = new UserEntity();
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        UserEntity result = userService.save(userEntity);

        assertEquals(userEntity, result);
    }

    @Test
    public void testGetUserDetails() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@example.com");

        DisplayUserDTO displayUserDTO = new DisplayUserDTO();
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(userEntity));
        when(userMapper.userToDetailsDTO(userEntity)).thenReturn(displayUserDTO);

        DisplayUserDTO result = userService.getUserDetails("test@example.com");

        assertEquals(displayUserDTO, result);
    }

    @Test
    public void testGetUsers() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@example.com");

        List<UserEntity> userList = List.of(userEntity);

        DisplayUserTableDTO displayUserTableDTO = new DisplayUserTableDTO();
        when(userRepository.findAll()).thenReturn(userList);
        when(userMapper.userToUserTableDTO(userEntity)).thenReturn(displayUserTableDTO);

        List<DisplayUserTableDTO> result = userService.getUsers();

        assertEquals(1, result.size());
        assertEquals(displayUserTableDTO, result.get(0));
    }

    @Test
    public void testFindNewDailyUsers() {
        when(userRepository.countAllByRegisteredAtAfter(any(LocalDateTime.class))).thenReturn(5);

        int result = userService.findNewDailyUsers();

        assertEquals(5, result);
    }
}

