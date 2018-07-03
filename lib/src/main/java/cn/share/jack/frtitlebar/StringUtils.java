package cn.share.jack.frtitlebar;

import android.support.annotation.Nullable;
import android.widget.EditText;

/**
 * Created by jack on 2018/2/1
 */

public class StringUtils {

    private StringUtils() {
    }

    public static String EMPTY_STRING = "";

    public static String valueOf(Object value) {
        return value != null ? value.toString() : EMPTY_STRING;
    }

    public static boolean isEmpty(@Nullable String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isEmpty(String... strings) {
        for (String str : strings) {
            if (str == null || str.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static String getEditTextContent(EditText editText) {
        if (editText == null) {
            return null;
        } else {
            return editText.getText().toString().trim();
        }
    }

}