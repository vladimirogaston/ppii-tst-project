package model;

import java.util.HashSet;
import java.util.Set;

public class Agenda {

    private Set<Persona> personaSet;

    public Agenda() {
        this.personaSet = new HashSet<>();
    }

    public void agregar(Persona persona){
        personaSet.add(persona);
    }

    public Set<Persona> readAll() {
        return this.personaSet;
    }

    public void remove(String nombre) {
        personaSet.forEach(p-> {
            if(p.getNombre().equals(nombre)) {
                personaSet.remove(p);
            }
        });
    }
}
