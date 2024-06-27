package Controller;

import java.security.spec.KeySpec;
import java.time.LocalDate;
import java.time.Month;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class EncrypPassWord {

    //The javax.crypto library is an  that has classes to encrypt data,, an example is Cipher is a class that allows me to encrypt and descrypt data
    public String encryptPassword(final String user, final String passWordOriginal) {
        try {

            // VARIABLES QUE SE NECESTITAN PARA GENERAR UNA CLAVE ALEATORIA
            String bytesIv = "1234567890123456"; // 128 bits (16 caracteres) para AES-128
            // Configuración de la función PBKDF2 para derivar la clave
            String salt = "somesalt"; // Puedes generar un salt aleatorio que se combinara con la clave antes de que se encripte la contraseña
            int iterations = 10000; // Número de iteraciones , en las que cambiara de valor la clave y cada vez la volvera mas segura 
            int keyLength = 128; // Longitud de la clave que tiene que alcanzar

            // PRIMERA PARTYE DONDE SOLO OBTENGO UNA CLAVE TIPO ALEATORIA
            // The secretFactory es una clase que permite usar ciertos algoritmos para la generacion de claves
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); // Instancio el tipo de algoritmo para obtener la contraseña
            /* Preparo todos los parametros(mi clave por caracteres, salt los bytes que se combinaran con mi clave antes de ser creada la nueva contraseña,
            las iteraciones el numero de vueltas pára poder obtener la clave , el tamaño que debe tener mi clave para estar lista*/
            KeySpec keySpec = new PBEKeySpec(user.toCharArray(), salt.getBytes(), iterations, keyLength);
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);  // Creo la clave aleatoria con los datos datos dados anteriormente,AQUI SI EJECUTO

            // SEGUNDA PARTE, DONDE YA JUNTO LA CLAVE CREADA ANTERIORMENTE Y LA UNO CON CONTRASEÑA ORIGINAL PAREA OBTENER EL ULTIMO RESULTADO
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES"); // Ahora si encripto la clave(Byte de la clave creada anteorimente, Algoritmo que se usara para encriptar la contraseña
            // Configuración del cifrador AES(el tipo de cifrado, el metodo para cibrar que utilizara el AES, la funcion que me servira rellenar la cadena y cumnpla con los bytes establecidos
            Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytesIv.getBytes("UTF-8")); // Genero un numero de bytes aleatorios...
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec); // Aqui lo que hago iniciar el cipher , como una clase normal, ya lista para realizar sus metodos de cifrado. AQUI NO EJECUTO 
            // Encriptación de la contraseña original
            byte[] encryptedPassword = encryptCipher.doFinal(passWordOriginal.getBytes("UTF-8")); //Aqui si junto todo con la contraseña original y ejecuto la sentencia y obtengo la contraseña encryptada, AQUI SI EJECUTO
            String encryptedPasswordBase64 = Base64.getEncoder().encodeToString(encryptedPassword); // La nueva clave la convierto en un String
            System.out.println("Ciphertext: " + encryptedPasswordBase64);
            return encryptedPasswordBase64;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

 
}
