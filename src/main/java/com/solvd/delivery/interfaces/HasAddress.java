package com.solvd.delivery.interfaces;

import com.solvd.delivery.classes.places.Address;

public interface HasAddress {
    
    Address getAddress();

    void setAddress(Address address);
}
