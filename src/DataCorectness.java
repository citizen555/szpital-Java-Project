import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DataCorectness {
    //tfPesel
    public static boolean pesel(String data){
        int x=data.length();
        long y= 0;
        if (x!=11){
            return false;
        }else{
            try{
                y=Long.parseLong(data);
            }catch(NumberFormatException ex){
                ex.printStackTrace();
                return false;
            }
            return true;
        }
    }
    //tfName and tfSurname
    public static boolean name(String data){
        for (char c : data.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    //Date
    public static boolean date(String data){
        String format = "yyyy-MM-dd";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            dateFormat.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    //Hour
    public static boolean time(String data){
        String format = "hh-mm-ss";
        try {
            SimpleDateFormat timeFormat = new SimpleDateFormat(format);
            timeFormat.setLenient(false);
            timeFormat.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    //Postcode
    public static boolean postCode(String data){
        Pattern pattern = Pattern.compile("^[0-9]{2}-[0-9]{3}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
    //Email
    public static boolean email(String data){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
    //telephone number
    public static boolean telephone(String data){
        Pattern pattern = Pattern.compile("^[0-9]{9}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
    //String contains number or specal character
    public static boolean containsNumberAndChars(String data){
        Pattern pattern = Pattern.compile("[^a-zA-Z\\s]");
        Matcher matcher = pattern.matcher(data);
        return !matcher.find();
    }
    //String contains number
    public static boolean salary(String data){
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}


