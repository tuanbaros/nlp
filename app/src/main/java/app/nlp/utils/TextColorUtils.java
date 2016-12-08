package app.nlp.utils;

import android.text.Html;
import android.text.Spanned;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tuannt on 29/11/2016.
 */

public class TextColorUtils {
    public static Spanned changeTextColor(String key, String text) {
        Matcher matcher = Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(text);
        String s = key;
        if (matcher.find()) {
            s = matcher.group();
        }
        Log.i("color", s);
        String[] array = text.split(Pattern.quote(s));
        Log.i("length", ""+ array.length);
        StringBuilder stringBuilder = new StringBuilder();
        if (array.length > 1) {
            for (int i = 0; i < array.length-1; i++) {
                stringBuilder.append(array[i] + "<font color='yellow'>" + s + "</font>");
            }
            stringBuilder.append(array[array.length-1]);
        } else {
            if (array.length == 1)
                if (text.contains(s))
                    stringBuilder.append(array[0] + "<font color='yellow'>" + s + "</font>");
                else
                    stringBuilder.append(array[0]);
        }
        return Html.fromHtml(stringBuilder.toString());
    }
}
