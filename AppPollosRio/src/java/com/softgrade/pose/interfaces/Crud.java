/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softgrade.pose.interfaces;

import java.util.List;

/**
 *
 * @author Gabriela
 */
public interface Crud <CualquierClase>{
    public boolean crea(CualquierClase c);
    public boolean borra(Object llave);
    public boolean actualiza(CualquierClase c);
    public CualquierClase trae(Object llave);
    public List<CualquierClase> busca();
}
