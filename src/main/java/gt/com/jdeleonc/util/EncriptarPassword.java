package gt.com.jdeleonc.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Jan Carlo
 */
public class EncriptarPassword {

    public static void main(String[] args) {

        var password = "123";
        System.out.println("password sin encriptar = " + password);
        System.out.println("password encriptada = " + encriptarPassword(password));

    }

    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
