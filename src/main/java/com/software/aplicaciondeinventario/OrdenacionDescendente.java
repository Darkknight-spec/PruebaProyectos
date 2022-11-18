package com.software.aplicaciondeinventario;

import java.util.Comparator;

public class OrdenacionDescendente implements Comparator<String>{

    @Override
    public int compare(String primerObjeto, String segundoObjeto) {
        return segundoObjeto.compareTo(primerObjeto);
    }
    
}
