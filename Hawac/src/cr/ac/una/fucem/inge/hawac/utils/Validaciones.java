package cr.ac.una.fucem.inge.hawac.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validaciones {

    public static final String emailPatron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final Pattern pMail = Pattern.compile(emailPatron);
    public static final Pattern pNum = Pattern.compile("\\d");
    public static final String telPatron = "(\\d{8}|(\\d{2}-){3}\\d{2})";
    public static final String telPatron1 = "\\d{8}";
    public static final Pattern pTel = Pattern.compile(telPatron);
    public static final Pattern pTel1 = Pattern.compile(telPatron1);

    public static final String idPatron = "^[1-9]+\\d{8}";
    public static final Pattern pId = Pattern.compile(idPatron);

    public static boolean validarEmail(String e) {
        Matcher m = pMail.matcher(e);
        return m.matches();
    }

    public static boolean validarCedula(String id) {
        Matcher m = pId.matcher(id);
        return m.matches();
    }

    public static String validarTel(String tel) {
        Matcher m = pTel.matcher(tel);
        Matcher m1 = pTel1.matcher(tel);
        String newTel = new String();
        if (m.matches()) {
            if (m1.matches()) {
                newTel += tel.substring(0, 2) + "-";
                newTel += tel.substring(2, 4) + "-";
                newTel += tel.substring(4, 6) + "-";
                newTel += tel.substring(6, 8);
                return newTel;
            }
            return tel;
        }
        return null;
    }

    public static boolean validarBusqueda(String b, String cadena) {
        String busquedaPatron = "^" + b + "([_A-Za-z0-9-])*";
        Pattern pBus = Pattern.compile(busquedaPatron, Pattern.CASE_INSENSITIVE);
        Matcher m = pBus.matcher(cadena);
        return m.matches();

    }
    
//    public static boolean isNumeric(String arg){
//        Matcher m = pNum.matcher(arg);
//        boolean j = m.matches();
//        return m.matches();
//    }

//	public static void main(String [] args){
//		/*if(validarBusqueda(args[0],args[1])){
//			System.out.println("true");
//		}else{
//			System.out.println("false");
//		}*/
//		
//		/*
//		String tel =args[0];
//		tel = validarTel(tel); 
//		if(tel!=null){
//			System.out.println("el String es un tel");
//		}else{
//			System.out.println("el String no es un tel");
//		}
//		System.out.println("tel: "+tel);
//		*/
//		
//		/*if(validarCedula(args[0])){
//			System.out.println("true");
//		}else{
//			System.out.println("false");
//		}*/
//		
//	}
}
