/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.jdeleonc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Jan Carlo
 */
@Entity
@Data
@Table(name="usuariospring")
public class Usuario implements Serializable{
    private static final long serialVersionUID= 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    
    @OneToMany
    @JoinColumn(name="ID_Usuario")
    private List<Rol> roles;
    
}
