

import java.io.*;
import java.util.*;

public class CaesarCipherJava {
    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList();
        try {

            BufferedReader reader = new BufferedReader(new FileReader("word.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Map map = new HashMap();
        String message, decryptedMessage = "";
        int key;
        char ch;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a message: ");
        message = sc.nextLine();


        key = 0;
        int numberWordsCorrect = 0;
        boolean testing = true;
        boolean negative = false;

        while (testing) {
            decryptedMessage = "";
            numberWordsCorrect = 0;

            if (key == 26) {
                key = -1;
                negative = true;
            } else {
                if (negative) {
                    key--;
                } else {
                    key++;
                }

            }

            for(int i = 0; i < message.length(); ++i){
                ch = message.charAt(i);

                if(ch >= 'a' && ch <= 'z'){
                    ch = (char)(ch - key);

                    if(ch < 'a'){
                        ch = (char)(ch + 'z' - 'a' + 1);
                    }

                    decryptedMessage += ch;
                }
                //System.out.println(decryptedMessage);
                else if(ch >= 'A' && ch <= 'Z'){
                    ch = (char)(ch - key);

                    if(ch < 'A'){
                        ch = (char)(ch + 'Z' - 'A' + 1);
                    }

                    decryptedMessage += ch;
                }
                else {
                    decryptedMessage += ch;
                }
            }

            String[] words = decryptedMessage.split(" ");
            for (String word: words) {
                if (arrayList.contains(word)) {
                    numberWordsCorrect++;
                }
            }

            if (decryptedMessage.length() < 3) {
                if (numberWordsCorrect >= 1) {
                    System.out.println("Decrypted message: " + decryptedMessage);
                    System.out.println("The key is: " + key);
                    testing=false;
                }
            } else {

                if (numberWordsCorrect > words.length /3) {
                    System.out.println("Decrypted message: " + decryptedMessage);
                    System.out.println("The key is: " + key);
                    testing = false;
                }
            }




            if (key == -26) {

                System.out.println("Testing failed to get decryption");
                testing = false;
            }
        }

    }
}
