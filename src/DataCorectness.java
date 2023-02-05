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
    //tfName and surname
    public static boolean name(String data){
        for (char c : data.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


}
