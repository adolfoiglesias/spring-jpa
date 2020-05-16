package com.calarix.data.jpa.specification;

import com.calarix.data.jpa.Customer;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.spi.CalendarNameProvider;

public class CustomerSpecifications {
    public static Specification<Customer> customerHasBirthday() {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                LocalDate today = LocalDate.now();
                return criteriaBuilder.equal(root.get("birthday"), today);
            }
        };
    }

    public static Specification<Customer> isLongTermCustomer() {

        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                LocalDate localDate = LocalDate.now().minusYears(2l);
                return criteriaBuilder.lessThan(root.get("createdAt"), localDate);

            }
        };
    }
}
