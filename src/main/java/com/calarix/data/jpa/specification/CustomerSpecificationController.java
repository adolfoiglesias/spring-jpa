package com.calarix.data.jpa.specification;

import com.calarix.data.jpa.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerSpecificationController {

    private static final Logger log = LoggerFactory.getLogger(CustomerSpecificationController.class);

    @Autowired
    private CustomerSpecificationRepository  customerRepository;

    @GetMapping("list/specification")
    public ResponseEntity<List> findAllSinQueryDsl(){
        List<Customer> customerList = customerRepository
                .findAll(
                        Specification.where(CustomerSpecifications.customerHasBirthday())
                                     .and(CustomerSpecifications.isLongTermCustomer()));
        return ResponseEntity.ok(customerList);
    }


}
