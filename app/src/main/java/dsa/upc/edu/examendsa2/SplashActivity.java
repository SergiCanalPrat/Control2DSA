package dsa.upc.edu.examendsa2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

    public class SplashActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            final SharedPreferences sharedPref =
                    PreferenceManager.getDefaultSharedPreferences(this);
            boolean registered = sharedPref.getBoolean("registered", false);
            Log.d("tag", "Registered: " + registered);
            Class where;
            if (!registered) {
                where = LoginActivity.class;
            } else {
                where = MainActivity.class;
            }
            Intent intent = new Intent(this, where);
            startActivity(intent);

            finish();
        }

    }

