package cipherFunctionalProcess;

public class FunctionalProcess {

    String msgTxt;
    String comLvl;
    String pass;
    char charArray[];
    static int charValue = 0;

    public void initializedValue(String t, String c, String p) {
        msgTxt = t;
        comLvl = c;
        pass = p;
    }

    /*filterTxtComFd funtion cheaking compressed value is a positive number or not.
     Also check first left side value is zero(0) or not*/
    public boolean filterTxtComFd(String comLvlTxt) {

        int chValue;
        if (comLvlTxt.isEmpty()) {
            return false;
        }
        char txtArray[];
        txtArray = comLvlTxt.toCharArray();

        int firstCharVal = txtArray[0];
        for (char ch : txtArray) {
            chValue = ch;
            if (firstCharVal == 48) {
                return false;
            } else if (chValue < 48 || chValue > 57) {
                return false;
            }

        }
        return true;
    }

    /*---comapare password---*/
    public boolean isPassMatch() {
        int counter = 0;

        for (String str : msgTxt.split(" ")) {
            counter++;
        }

        /*-------strArray contain text as a string array by spliting-----*/
        String strArray[] = new String[counter];

        /*--------spliting encrypted text-------*/
        int i = 0;
        for (String str : msgTxt.split(" ")) {
            strArray[i] = str;
            i++;
        }

        /*----secret----*/
        String hashEnStr = (strArray[counter - 1]);
        int hiddenP = pass.hashCode();
        String hashDeStr = Integer.toString(hiddenP / 17395);

        if (hashDeStr.equals(hashEnStr)) {
            return true;
        }
        return false;
    }

    /*---txtToEncryptTxt function in functionalProccess class to encrypt text---*/
    public String[] txtToEncryptTxt() {
        int counter = 0;
        charArray = msgTxt.toCharArray();
        int newArray[] = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            charValue = charArray[i];
            newArray[i] = charValue;
            counter++;
        }

        String encryptArr[] = new String[counter];
        int compLvl = Integer.parseInt(comLvl);
        for (int i = 0; i < charArray.length; i++) {
            encryptArr[i] = Integer.toHexString(newArray[i] * compLvl * 5);
        }
        return encryptArr;
    }

    /*---txtToDecryptTxt function in functionalProccess class to decrypt text---*/
    public String txtToDecryptTxt() {

        int counter = 0;
        int compressedLvl = Integer.parseInt(comLvl);

        for (String str : msgTxt.split(" ")) {
            counter++;
        }

        /*----valueArray contain integer value for every elements from copyStrArray----*/
        int valueArray[] = new int[counter];

        /*-------strArray contain text as a string array by spliting-----*/
        String strArray[] = new String[counter];

        /*--------copyStrArray contain every element from strArray without last index element------*/
        String copyStrArray[] = new String[counter - 1];

        /*----decryptTxt contain final decrypt text*/
        String decryptTxt = "";

        /*--------spliting encrypted text-------*/
        int i = 0;
        for (String str : msgTxt.split(" ")) {
            strArray[i] = str;
            i++;
        }

        //secret
        String hashStr = (strArray[counter - 1]);

        /*---- copy element without last index element from strArray to copyStrArray----*/
        for (int j = 0; j < counter - 1; j++) {
            copyStrArray[j] = strArray[j];
        }

        /*-----putting integer value of every copyStrArray element to valueArray-------*/
        for (int j = 0; j < copyStrArray.length; j++) {
            valueArray[j] = Integer.parseInt(copyStrArray[j], 16);
        }

        char temp;

        for (int j=0;j<counter-1; j++) {
            temp = (char) (valueArray[j] / (5 * compressedLvl));
            decryptTxt += temp;
        }
        return decryptTxt;
    }
}
