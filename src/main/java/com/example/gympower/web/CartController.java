package com.example.gympower.web;

import com.example.gympower.model.dto.EditCartDTO;
import com.example.gympower.model.dto.DisplayCartItemDTO;
import com.example.gympower.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController()
public class CartController {

    private final UserService userService;

    public CartController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/cart/addProduct")
    public ResponseEntity<String> addProductToCart(@RequestParam("email") String email,
                                                   @RequestBody EditCartDTO cartItem) throws Exception {
        String result = this.userService.manipulateCart(email, cartItem, "add");

        return ResponseEntity.ok(result);
    }

    @PostMapping("/cart/removeProduct")
    public ResponseEntity<String> removeProductFromCart(@RequestParam("email") String email,
                                                        @RequestBody EditCartDTO cartDTO) throws Exception {

        String result = this.userService.manipulateCart(email, cartDTO, "remove");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/cart/products")
    public ResponseEntity<List<DisplayCartItemDTO>> getCart(@RequestParam("email") String email) throws Exception {
        List<DisplayCartItemDTO> result = this.userService.getCart(email);

        return ResponseEntity.ok(result);
    }
}
