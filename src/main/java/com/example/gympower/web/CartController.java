package com.example.gympower.web;

import com.example.gympower.model.dto.CartDTO;
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
    public ResponseEntity<String> addProductToCart(@RequestParam("email") String email, @RequestParam("productId") long id) throws Exception {
        String result = this.userService.manipulateCart(email, id, "add");

        return ResponseEntity.ok(result);
    }

    @PostMapping("/cart/removeProduct")
    public ResponseEntity<String> removeProductFromCart(@RequestParam("email") String email, @RequestParam("productId") long id) throws Exception {
        String result = this.userService.manipulateCart(email, id, "remove");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/cart/products")
    public ResponseEntity<List<CartDTO>> getCart(@RequestParam("email") String email) throws Exception {
        List<CartDTO> result = this.userService.getCart(email);

        return ResponseEntity.ok(result);
    }
}
