/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.jdeleonc.web;

import gt.com.jdeleonc.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import gt.com.jdeleonc.servicio.PersonaService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Jan Carlo
 */
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired 
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var personas = personaService.listarPersonas();
        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario que hizo Login: " + user);
        model.addAttribute("personas", personas);
        
        var saldoTotal =0D;
        for(var p: personas){
            saldoTotal += p.getSaldo();
        }
        
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar"; 
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        
        personaService.guardar(persona);
        return "redirect:/";
        
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona,Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona,Model model){
        personaService.eliminar(persona);
        
        return "redirect:/";
    }
    
    
}
