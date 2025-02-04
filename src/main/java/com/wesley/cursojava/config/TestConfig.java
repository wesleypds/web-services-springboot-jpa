package com.wesley.cursojava.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wesley.cursojava.entities.Category;
import com.wesley.cursojava.entities.Order;
import com.wesley.cursojava.entities.OrderItem;
import com.wesley.cursojava.entities.Payment;
import com.wesley.cursojava.entities.Product;
import com.wesley.cursojava.entities.User;
import com.wesley.cursojava.entities.enums.OrderStatus;
import com.wesley.cursojava.repositories.CategoryRepository;
import com.wesley.cursojava.repositories.OrderItemRepository;
import com.wesley.cursojava.repositories.OrderRepository;
import com.wesley.cursojava.repositories.ProductRepository;
import com.wesley.cursojava.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        // Instanciando usuários e salvando no banco
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        // Instanciando pedidos e salvando no banco
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // Instanciando categorias e salvando no banco
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // Instanciando produtos e salvando no banco
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        p1.getCategories().add(cat1);

        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        p2.getCategories().addAll(Arrays.asList(cat1, cat3));

        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        p3.getCategories().add(cat3);

        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        p4.getCategories().add(cat3);

        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // Instanciando itens de pedido e salvando no banco
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        // Adicionando pagamentos à pedidos e salvando no banco
        Payment pa1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
        o1.setPayment(pa1);

        orderRepository.save(o1);

    }

}
