package de.hhbk.de.cb.other;

import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 17.09.15.
 */

public class WebConnection extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected JSONObject doInBackground(String... logindaten) {
        URL url;
        JSONObject jsonObject = null;
        String name = logindaten[0];
        String password = logindaten[1];

        try {
            debug.getInt().message("Start: Do in Background; Name: "+name+" Passw.:"+password);
            url = new URL("http://hhbk.bplaced.net/login.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("POST");
            String USER_AGENT = "Mozilla/5.0";
            connection.setRequestProperty("User-Agent", USER_AGENT);

            debug.getInt().message("URL encoded string.");
            String urlParameters = "username=" + URLEncoder.encode(name, "UTF-8") + "&passwort=" + URLEncoder.encode(password, "UTF-8");//oeni geheim
            debug.getInt().message("Sende Request");
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), "ISO-8859-1");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String response;
                StringBuilder sb= new StringBuilder();
                while ((response = bufferedReader.readLine()) != null) {
                    sb.append(response);
                }
                bufferedReader.close();
                debug.getInt().message("Lang: " + sb);//{"success":1,"message":"Login erfolgreich!","nachname":"Oenings","vorname":"Frank","anrede":"Herr","kuerzel":"OENI"}
                jsonObject = makeAJSON(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private JSONObject makeAJSON(String s) {
        s=s.substring(1, s.length()-1);
        //{"success":1,"message":"Login erfolgreich!","nachname":"Oenings","vorname":"Frank","anrede":"Herr","kuerzel":"OENI"}
        Map<String, String> map = new HashMap<>();
        String[] pairs = s.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0];
            String value = keyValue[1];

            key = key.substring(1, key.length() - 1);
            if (value.length() > 1) {
                value = value.substring(1, value.length() - 1);
            }
            map.put(key, value);
        }
        debug.getInt().message("Kurz: " + map);
        return new JSONObject(map);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}