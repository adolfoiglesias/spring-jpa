package com.calarix.data.jpa.projection;

import lombok.Data;

public interface AddressView {
    public String getZipCode();

    // se obtiene el personview porque e address es el owner de la relacion.
    // Del Personview no puede obtenerse un AddressVew porque es el inverse de la relacion
    public PersonView getPerson();
}
