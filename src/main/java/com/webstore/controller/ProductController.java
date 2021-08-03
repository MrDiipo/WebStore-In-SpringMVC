package com.webstore.controller;

import com.webstore.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class ProductController {

    @RequestMapping("/products")
    public String list(Model model){
        Product iphone = new Product("P1234", "iPhone 6s", new BigDecimal(500));

        iphone.setDescription("Apple iPhone 6s smartphone\n" +
                "with 4.00-inch 640x1136 display and 8-megapixel rear\n" +
                "camera");
       iphone.setCategory("Smartphone");
       iphone.setManufacturer("Apple");
       iphone.setUnitsInStock(1000);
       model.addAttribute("products", iphone);
       return "products";
    }
}
