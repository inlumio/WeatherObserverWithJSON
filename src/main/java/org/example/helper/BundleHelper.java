package org.example.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleHelper {

   private static ResourceBundle bundle = ResourceBundle.getBundle("message", new Locale("en", "US"));

    public static ResourceBundle getBundle() {
        return bundle;
    }
}
