


import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Scanner;

public class APIHandler {

    public Trivia getCategories(){
        try {
            URL url = new URL("https://opentdb.com/api_category.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode != 200) {
                System.out.println(responseCode);
                throw new RuntimeException("response code " + responseCode);
            } else {

                StringBuilder information = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());

                while (scanner.hasNext()) {
                    information.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(information);
                String info = String.valueOf(information);

                Gson gson = new Gson();
                Trivia trivia = gson.fromJson(info, Trivia.class);

                return trivia;

            }
        } catch (java.net.MalformedURLException e) {
            System.out.println("get categories failed URL");
        } catch(IOException e){
            System.out.println("get categories failed IO");
        } catch(RuntimeException e) {
            System.out.println("error when retrieving info");
            System.out.println(e);
        }
        return null;
    }

    public TriviaQuestions getQuestions(String category, String numberOfQuestions, String difficulty) throws RuntimeException{
        try {
            URL url = new URL("https://opentdb.com/api.php?amount=" + numberOfQuestions +"&category="+category+"&difficulty="+difficulty+"&type=multiple");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode != 200) {
                System.out.println(responseCode);
                throw new RuntimeException("response code " + responseCode);
            } else {

                StringBuilder information = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());

                while (scanner.hasNext()) {
                    information.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(information);
                String info = String.valueOf(information);

                Gson gson = new Gson();
                TriviaQuestions questions = gson.fromJson(info, TriviaQuestions.class);

                return questions;

            }
        } catch (java.net.MalformedURLException e) {
            System.out.println("get categories failed URL");
        } catch(IOException e){
            System.out.println("get categories failed IO");
        }
        return null;
    }


}
