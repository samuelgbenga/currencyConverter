import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args){
        HashMap<Integer, String>  currencyCodes = new HashMap<Integer, String>();

        // add currency codes
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "CAD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "INR");
        //currencyCodes.put(6, "USD");

        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("welcome to the currency converter! ");

        System.out.println("currency convert FROM? ");

        System.out.println("1:USD (US Dollar) \t 2:CAD (Canadian Dollar) \t 3:EUR (Euro) \t 4:HKD (Hong Kong Dollar) \t 5:INR (Indian Rupee)");

        fromCode = currencyCodes.get(sc.nextInt());

        System.out.println("currency convert TO? ");

        System.out.println("1:USD (US Dollar) \t 2:CAD (Canadian Dollar) \t 3:EUR (Euro) \t 4:HKD (Hong Kong Dollar) \t 5:INR (Indian Rupee)");

        toCode = currencyCodes.get(sc.nextInt());

        System.out.println("Amount you wish to convert?");
        amount = sc.nextFloat();

        //sendHttpGetRequest(fromCode, toCode, amount);
        //AUZ5js21S3F8Sylbi3fbGkMKnpulG0Km
        //AUZ5js21S3F8Sylbi3fbGkMKnpulG0Km
        //https://api.apilayer.com/exchangerates_data/latest?symbols=USD&base=CAD&apikey=AUZ5js21S3F8Sylbi3fbGkMKnpulG0Km

        System.out.println("Thank you for using the currency converter!");
    }

    private static void sendHttpGetRequest(String fromCode, String toCode, double amount) throws IOException {
        String GET_URL = "https://api.apilayer.com/exchangerates_data/latest?base=" + toCode + "&symbols=" + fromCode + "&apikey=AUZ5js21S3F8Sylbi3fbGkMKnpulG0Km";

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){// success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }in.close();
        }

        

    }
}

//https://api.apilayer.com/exchangerates_data/latest?symbols=USD&base=CAD&apikey=AUZ5js21S3F8Sylbi3fbGkMKnpulG0Km

//https://api.apilayer.com/exchangerates_data/latest?base=USD&symbols=CAD&apikey=AUZ5js21S3F8Sylbi3fbGkMKnpulG0Km
