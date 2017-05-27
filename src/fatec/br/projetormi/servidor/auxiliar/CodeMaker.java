/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fatec.br.projetormi.servidor.auxiliar;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */
public class CodeMaker {
    
    public static String criaSenha() {
        //Date date = new Date();
        //String codigo;
        
        //codigo = Long.toString(date.getTime());
       // codigo = codigo.substring(6);
       // return Integer.parseInt(codigo);
        String codigo = UUID.randomUUID().toString();
        long l = ByteBuffer.wrap(codigo.getBytes()).getShort();
         return Long.toString(l, Character.MAX_RADIX);
        
    }

}
