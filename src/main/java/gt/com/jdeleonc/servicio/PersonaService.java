/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.jdeleonc.servicio;

import gt.com.jdeleonc.domain.Persona;
import java.util.List;

/**
 *
 * @author Jan Carlo
 */
public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar (Persona persona);
    
    public void eliminar (Persona persona);
    
    public Persona encontrarPersona (Persona persona);
    
    
}
