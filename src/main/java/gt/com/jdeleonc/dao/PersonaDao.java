/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.jdeleonc.dao;

import gt.com.jdeleonc.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jan Carlo
 */

public interface PersonaDao extends JpaRepository<Persona,Long>{
    
}
