package com.calarix.data.jpa.projection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<AddressView> getAddressByState(String state);
}
