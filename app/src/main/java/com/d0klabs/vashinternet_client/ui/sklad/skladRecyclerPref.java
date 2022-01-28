package com.d0klabs.vashinternet_client.ui.sklad;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

public class skladRecyclerPref {
    Context skladcontext;
    SharedPreferences sharedPreferences;

    public skladRecyclerPref(Context skladcontext) {
        this.skladcontext = skladcontext;
    }

    public String getSkladSharetext() {
        sharedPreferences = skladcontext.getSharedPreferences("button", Context.MODE_PRIVATE);
        return sharedPreferences.getString("buttonname","").toLowerCase(Locale.ROOT);
    }
}
