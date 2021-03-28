package controller;

import model.Persona;

import java.util.Set;

public interface QueryController {

    Set<Persona> read();
}
