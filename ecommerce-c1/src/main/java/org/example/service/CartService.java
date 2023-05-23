package org.example.service;
import org.example.model.Cart;
import org.example.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> updateCart(Long id, Cart updatedCart) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            updatedCart.setId(id);
            return Optional.of(cartRepository.save(updatedCart));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteCart(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            cartRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
