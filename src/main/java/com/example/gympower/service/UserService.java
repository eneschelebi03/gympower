package com.example.gympower.service;

import com.example.gympower.model.dto.EditCartDTO;
import com.example.gympower.model.dto.DisplayCartItemDTO;
import com.example.gympower.model.entity.CartItem;
import com.example.gympower.model.entity.UserEntity;
import com.example.gympower.model.entity.UserRole;
import com.example.gympower.model.entity.enums.UserRolesEnum;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.model.mapper.ProductMapper;
import com.example.gympower.repository.UserRepository;
import com.example.gympower.repository.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    private final WearService wearService;

    private final CartItemService cartItemService;

    private final ProductMapper productMapper;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, WearService wearService, CartItemService cartItemService, ProductMapper productMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.wearService = wearService;
        this.cartItemService = cartItemService;
        this.productMapper = productMapper;
    }

    public String manipulateCart(String email, EditCartDTO cartDTO, String method) throws Exception {
        Optional<UserEntity> userOpt = this.userRepository.findByEmail(email);

        UserEntity user = userOpt.orElseThrow(() -> new Exception("User not found"));

        Wear wear = this.wearService.findWear(cartDTO.getWearId());

        if (method.equals("add")) {

            CartItem cartItem = new CartItem()
                    .setColor(cartDTO.getColor())
                    .setSize(cartDTO.getSize())
                    .setWear(wear);

            cartItem = this.cartItemService.add(cartItem);
            user.getCartItems().add(cartItem);

        } else {

            CartItem cartItem = this.cartItemService.findById(cartDTO.getWearId());

            user.getCartItems().remove(cartItem);

            this.cartItemService.remove(cartItem);

        }

        this.userRepository.save(user);

        return user.getEmail() + " -> " + wear.getName();
    }



    public void init() {
        UserRole adminRole = new UserRole().setRole(UserRolesEnum.ADMIN);
        UserRole moderatorRole = new UserRole().setRole(UserRolesEnum.MODERATOR);
        UserRole userRole = new UserRole().setRole(UserRolesEnum.USER);

        adminRole = this.userRoleRepository.save(adminRole);
        moderatorRole = this.userRoleRepository.save(moderatorRole);
        userRole = this.userRoleRepository.save(userRole);

        initAdmin(Set.of(adminRole, moderatorRole, userRole));
        initModerator(Set.of(moderatorRole, userRole));
        initUser(Set.of(userRole));
    }

    public void initUser(Set<UserRole> roles) {

        UserEntity user = new UserEntity()
                .setEmail("user_userov@gmail.com")
                .setPassword(this.passwordEncoder.encode("topsecret_user"))
                .setUsername("user123")
                .setFirstName("User")
                .setLastName("Userov")
                .setRoles(roles);

        this.userRepository.save(user);
    }

    public void initModerator(Set<UserRole> roles) {
        UserEntity moderator = new UserEntity()
                .setEmail("moderator_moderatorov@gmail.com")
                .setPassword(this.passwordEncoder.encode("topsecret_moderator"))
                .setUsername("moderator123")
                .setFirstName("Moderator")
                .setLastName("Moderatorov")
                .setRoles(roles);

        this.userRepository.save(moderator);

    }

    public void initAdmin(Set<UserRole> roles) {
        UserEntity admin = new UserEntity()
                .setEmail("admin_adminov@gmail.com")
                .setPassword(this.passwordEncoder.encode("topsecret_admin"))
                .setUsername("admin123")
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setRoles(roles);

        this.userRepository.save(admin);

    }

    public List<DisplayCartItemDTO> getCart(String email) throws Exception {
        Optional<UserEntity> userOpt = this.userRepository.findByEmail(email);

        UserEntity user = userOpt.orElseThrow(() -> new Exception("User not found"));

        List<DisplayCartItemDTO> result = user.getCartItems().stream()
                .map(this.productMapper::cartItemToCartDTO)
                .toList();

        return result;
    }
}
