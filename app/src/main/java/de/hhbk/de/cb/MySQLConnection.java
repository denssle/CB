package de.hhbk.de.cb;

import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by admin on 17.09.15.
 */

class MySQLConnection extends AsyncTask<String, Void, JSONObject> {
    // String: Logindaten als String Parameter übergeben
    // Void: Keine Fortschrittsanzeige
    // JSONObject: Rückgabe der Datenbankanfrage als JSON Objekt
    @Override
    protected void onPreExecute() {
    // Zeige einen Dialog während der gesamten Datenbankanfrage
    }

    @Override
    protected JSONObject doInBackground(String... logindaten) {
        // Verbindungsaufbau und DB-Anfrage im Hintergrund
        URL url = null;
        try {
            debug.getInt().message("Start: Do in Background.");
            url = new URL("http://hhbk.bplaced.net/login.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("POST");

            //URL encoded string.
            String urlParameters = "Username=" + URLEncoder.encode("oeni", "UTF-8") + "&Passwort=" + URLEncoder.encode("geheim", "UTF-8");
            //Sende Request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), "ISO-8859-1");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String response;
                StringBuilder sb=null;
                while ((response = bufferedReader.readLine()) != null) {
                    sb.append(response);
                }
                bufferedReader.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        JSONObject JSONObjekt = null;
        return JSONObjekt;
    }

    @Override
    protected void onPostExecute(JSONObject json) {
    // Task abgeschlossen, Ergebnis kann verwendet werden
    }
}