package techgig.pirates.com.helpinghand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class BrandActivity extends Activity {
    final long DELAYED_SECONDS=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        moveOnToNextActivity();
    }

    private void moveOnToNextActivity() {

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent nextActivityIntent = new Intent(getApplicationContext(),LoginActivity.class);
                nextActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(nextActivityIntent);
            }
        }, DELAYED_SECONDS);
    }
}
