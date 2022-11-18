package com.software.aplicaciondeinventario;

import java.util.Comparator;

public class OrdenacionAscendente implements Comparator<String>{

    @Override
    public int compare(String primerObjeto, String segundoObjeto) {
        return primerObjeto.compareTo(segundoObjeto);
    }
    
}
