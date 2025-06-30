package com.solvd.delivery.interfaces;

import com.solvd.delivery.classes.Address;

public interface HasAddress {
    
    Address getAddress();

    void setAddress(Address address);
}
