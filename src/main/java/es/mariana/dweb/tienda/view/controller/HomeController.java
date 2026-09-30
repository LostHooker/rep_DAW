/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2026 Thymeleaf (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package es.mariana.dweb.tienda.view.controller;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM yyyy", new Locale("es", "ES"));
        Calendar cal = Calendar.getInstance();
        model.addAttribute("today", dateFormat.format(cal.getTime()));

        Faker faker = new Faker(new Locale("es"));
        model.addAttribute("name", faker.name().firstName());
        model.addAttribute("productName", faker.commerce().productName());
        model.addAttribute("productCategory", faker.commerce().department());
        model.addAttribute("productPrice", faker.commerce().price());
        model.addAttribute("orderNumber", faker.number().numberBetween(1, 100));
        Date deliveryDate = faker.date().future(10, TimeUnit.DAYS);
        model.addAttribute("deliveryDate", deliveryDate);
        model.addAttribute("company", faker.company().name());
        model.addAttribute("email", faker.internet().emailAddress());
        return "home";
    }

    @GetMapping("/home1")
    public String home1() {
        return "home1";
    }

    @GetMapping("/home2")
    public String home2() {
        return "home2";
    }

}
