package com.SpartanSmallBusinessManager.customer_crud_api.Customer;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;


    /**
     * Get all customers.
     * http://localhost:8080/customers/all
     * @return
     */
    @GetMapping("/all")
    public Object getAllCustomers(Model model) {
        //return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
        model.addAttribute("customerList", service.getAllCustomers());
        model.addAttribute("title", "All Customers");
        return "customer/customer-list";
    }

    /**
     * Get a single customer.
     * http://localhost:8080/customers/8890
     * @param customerId
     * @return
     */
    @GetMapping("/{customerId:\\d+}")
    public String getACustomer(@PathVariable int customerId, Model model) {
        //return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
        Customer update = service.getCustomerById(customerId);
        model.addAttribute("customer", update);
        return "customer/customer-profile";
    }

    /**
     * Get customers by their name.
     * http://localhost:8080/customers/name?search=Grace
     * @param search
     * @return
     */
    @GetMapping("/name")
    public Object getCustomerByName(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
        //return new ResponseEntity<>(service.getCustomerByName(search), HttpStatus.OK);
        model.addAttribute("customerList", service.getCustomerByName(search));
        model.addAttribute("title", "Customer By Name" + search);
        return "customer/customer-list";
    }

    /**
     * Get customers by their usernames.
     * http://localhost:8080/customers/username?search=Gigi101
     * @param search
     * @return
     */
    @GetMapping("/username")
    public Object getCustomerByUsername(@RequestParam(name = "search") String search, Model model) {
        //return new ResponseEntity<>(service.getCustomerByUsername(search), HttpStatus.OK);
        model.addAttribute("customerList", service.getCustomerByUsername(search));
        model.addAttribute("title", "Customer By Username" + search);
        return "customer/customer-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customer-create";
    }

    /**
     * Create a customer profile.
     * http://localhost:8080/customers/new
     * @param customer
     * @return
     */
    @PostMapping("/new")
    public Object createCustomer(Customer customer, HttpSession session) {
        service.createCustomer(customer);
        session.setAttribute("customerId", customer.getCustomerId());
        return "redirect:/customers/" + customer.getCustomerId();
    }
    @GetMapping({"/home"})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/update/{customerId:\\d+}")
    public String updateForm(@PathVariable int customerId, Model model) {
        model.addAttribute("customer", service.getCustomerById(customerId));
        return "customer/customer-update";
    }

    /**
     * Update customer profiles.
     * http://localhost:8080/customers/update/8890
     * @param customerId
     * @param customer
     * @return
     */
    @PostMapping("/update/{customerId:\\d+}")
    public Object updateCustomer(@PathVariable int customerId, @ModelAttribute Customer customer) {
        customer.setCustomerId(customerId);
        service.updateCustomer(customerId, customer);
        //return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
        return "redirect:/customers/" + customerId;
    }

    /**
     * Get customer based on their grade level.
     * http://localhost:8080/customers/gradeLevel/Junior
     * @param gradeLevel
     * @return
     */
    @GetMapping("/gradeLevel/{gradeLevel}")
    public Object getCustomerGradeLevel(@PathVariable String gradeLevel, Model model) {
        //return new ResponseEntity<>(service.getCustomerByGradeLevel(gradeLevel), HttpStatus.OK);
        model.addAttribute("lionList", service.getCustomerByGradeLevel(gradeLevel));
        model.addAttribute("title", "Customer Current Grade Level: " + gradeLevel);
        return "customer/customer-list";
    }


    /**
     * Delete customer from table.
     * http://localhost:8080/customers/delete/8891
     * @param customerId
     * @return
     */
    @DeleteMapping("/delete/{customerId:\\d+}")
    public Object deleteCustomer(@PathVariable int customerId) {
        service.deleteCustomerById(customerId);
        //return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
        return "redirect:/home";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        Customer cust = service.authenticate(username, password);
        if (cust != null) {
            session.setAttribute("customerId", cust.getCustomerId());
            return "redirect:/customers/" + cust.getCustomerId(); // go to profile
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


}
