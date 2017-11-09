package com.tddc73.lab1.lab3components;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class HttpAsyncTask extends AsyncTask<String, Void, String> {

    private HttpAsyncTaskResponseHandler delegate;

    public HttpAsyncTask(HttpAsyncTaskResponseHandler delegate) {
        this.delegate = delegate;
    }

    /**
     * Making service call
     *
     * @param urlString - url to make request
     */
    private String makeServiceCall(String urlString) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        } catch (Exception e) {
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }


    /**
     * converts a inputStream to string by reading and appending while there is
     * something to read
     *
     * @param inputStream the InputStream to read from
     * @return string result
     * @throws IOException
     */
    private static String readStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        StringBuilder result = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null)
            result.append(line);

        inputStream.close();
        return result.toString();
    }

    @Override
    protected String doInBackground(String... strings) {
        return makeServiceCall(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        delegate.handleResponse(s);
    }
}
