package conversor.moedas.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class conversorMoedaAPI {
    private static final String API_KEY = "7957a900451ef61b5d3d97fd"; // Sua chave da Exchangerate-API

    public void converterUSDparaEUR(double valorUSD) {
        double taxa = obterTaxaDeCambio("USD", "EUR");
        double valorEUR = valorUSD * taxa;
        System.out.println(valorUSD + " USD = " + valorEUR + " EUR");
    }

    public void converterEURparaJPY(double valorEUR) {
        double taxa = obterTaxaDeCambio("EUR", "JPY");
        double valorJPY = valorEUR * taxa;
        System.out.println(valorEUR + " EUR = " + valorJPY + " JPY");
    }

    public void converterJPYparaUSD(double valorJPY) {
        double taxa = obterTaxaDeCambio("JPY", "USD");
        double valorUSD = valorJPY * taxa;
        System.out.println(valorJPY + " JPY = " + valorUSD + " USD");
    }

    public void converterEURparaUSD(double valorEUR) {
        double taxa = obterTaxaDeCambio("EUR", "USD");
        double valorUSD = valorEUR * taxa;
        System.out.println(valorEUR + " EUR = " + valorUSD + " USD");
    }

    public void converterUSDtoJPY(double valorUSD) {
        double taxa = obterTaxaDeCambio("USD", "JPY");
        double valorJPY = valorUSD * taxa;
        System.out.println(valorUSD + " USD = " + valorJPY + " JPY");
    }

    public void converterJPYtoEUR(double valorJPY) {
        double taxa = obterTaxaDeCambio("JPY", "EUR");
        double valorEUR = valorJPY * taxa;
        System.out.println(valorJPY + " JPY = " + valorEUR + " EUR");
    }

    private double obterTaxaDeCambio(String moedaBase, String moedaAlvo) {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaBase + "/" + moedaAlvo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                responseBuilder.append(line);
            }
            in.close();

            String jsonData = responseBuilder.toString();
            JsonObject json = new Gson().fromJson(jsonData, JsonObject.class);
            double taxa = json.get("conversion_rate").getAsDouble();
            return taxa;
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0; // Em caso de erro, retorna taxa zero (ou outro valor indicando erro)
        }
    }
}
