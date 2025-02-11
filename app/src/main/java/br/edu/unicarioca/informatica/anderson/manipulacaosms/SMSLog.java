package br.edu.unicarioca.informatica.anderson.manipulacaosms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SMSLog extends BroadcastReceiver {
    public SMSLog() {
    }

    private SharedPreferences preferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

            Bundle myBundle = intent.getExtras();
            SmsMessage [] messages = null;
            String strMessage = "";

            if (myBundle != null)
            {
                Object [] pdus = (Object[]) myBundle.get("pdus");

                messages = new SmsMessage[pdus.length];

                for (int i = 0; i < messages.length; i++)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        String format = myBundle.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                    }
                    else {
                        messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    }
                    strMessage += "SMS From: " + messages[i].getOriginatingAddress();
                    strMessage += " : ";
                    strMessage += messages[i].getMessageBody();
                    strMessage += "\n";
                }

                Log.e("SMS", strMessage);
                Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
            }

    }
}
