package com.example.alejofila.redditconsumer;

import android.support.test.InstrumentationRegistry;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alejofila on 29/01/17.
 */

public class FileTestUtils {

    public static String readFileFromAssets(String filePath) {

        try {
            InputStream fileIn = InstrumentationRegistry.getTargetContext().getAssets().open(filePath);
            int size = fileIn.available();

            byte[] bytes = new byte[size];
            fileIn.read(bytes);
            fileIn.close();
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return  "";
    }
}
