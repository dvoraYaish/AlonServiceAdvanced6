package com.yaish.alonserviceadvanced6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class PhoneReceiver extends BroadcastReceiver
{
    Context myContext;

    public void onReceive(Context context, Intent intent)
    {
        myContext = context;
        try {
            // TELEPHONY MANAGER class object to register one listner
            TelephonyManager tmgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            //Create Listner
            MyPhoneStateListener PhoneListener = new MyPhoneStateListener();

            // Register listener for LISTEN_CALL_STATE
            tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
            Log.d("MY", "CALL_STATE");

        } catch (Exception e) {
            Log.e("MY", "Phone Receive Error" + e);
        }
    }

    private class MyPhoneStateListener extends PhoneStateListener
    {
        boolean wasCall = false;
        public void onCallStateChanged(int state, String incomingNumber)
        {

            Log.d("MyPhoneListener", state + "   incoming no:" + incomingNumber);

            if (state == 1) {
                wasCall = true;
                String msg = "New Phone Call Event. Incomming Number : " + incomingNumber;
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(myContext, msg, duration);
                toast.show();
                Intent intent = new Intent(myContext, MusicService.class);
                intent.putExtra("action", "pause");
                myContext.startService(intent);

            }
            /*else if( state == 0 && wasCall)
            {
                wasCall = false;
                String msg = "Call closed";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(myContext, msg, duration);
                toast.show();
                Intent intent = new Intent(myContext, MusicService.class);
                intent.putExtra("action", "resume");
                myContext.startService(intent);
            }*/
        }

    }
}
