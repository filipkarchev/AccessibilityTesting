package eu.fbk.calc;

import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TestService extends IntentService {
    public static Context mContext=null;

    TestService(){
        super("GausCalc test service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        View rootView = ((Activity)mContext).getWindow().getDecorView().findViewById(android.R.id.content);

        //Getting the views and performing specific actions
        final  Button btnTwo =  ((Button) rootView.findViewById(R.id.buttonTwo));
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                btnTwo.performClick();
            }
        });

        final  Button btnAdd =  ((Button) rootView.findViewById(R.id.buttonAdd));
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                btnAdd.performClick();
            }
        });

        final  Button btnFive =  ((Button) rootView.findViewById(R.id.buttonFive));
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                btnFive.performClick();
            }
        });


        final  Button btnEquals =  ((Button) rootView.findViewById(R.id.buttonEqual));
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                btnEquals.performClick();
            }
        });

      final TextView txtInfo = ((TextView) rootView.findViewById(R.id.infoTextView));

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                String result =  txtInfo.getText().toString();

                // Asserting the result is what we expect
                if(result.equals("2+5 = 7"))
                {
                    Log.i("TestService","Test passed");
                    Toast.makeText(TestService.this.getApplicationContext(), "Test passed", Toast.LENGTH_LONG).show();
                }else
                {
                    Log.i("TestService","Test failed");
                    Toast.makeText(TestService.this.getApplicationContext(), "Test failed", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Clear the content, so the application continues as in the entry point
        final  Button btnClear =  ((Button) rootView.findViewById(R.id.buttonClear));
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                btnClear.performClick();
            }
        });

    }
}
