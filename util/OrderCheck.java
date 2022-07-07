package jdbc.bankmanage.util;

public class OrderCheck {
    public static int checkOrder(String input){
        int result=0;
        int index=0;
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(Character.isDigit(c)){
                if(i==input.length()-1)
                    index=i+1;
                else
                    index=i;
                continue;
            }
            else{
                index=i;
                break;
            }
        }
        String s=input.substring(0,index);
        switch(s){
            case "1":
                result=1;
                break;
            case "2":
                result=2;
                break;
            case "3":
                result=3;
                break;
            case "4":
                result=4;
                break;
            case "5":
                result=5;
                break;
            case "6":
                result=6;
                break;
            case "7":
                result=7;
                break;
            case "8":
                result=8;
                break;
            case "9":
                result=9;
                break;
            default:
                result=-1;
                break;
        }
        return result;
    }
}


