package techgig.pirates.com.helpinghand;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;



import de.hdodenhof.circleimageview.CircleImageView;

public class SettingsActivity extends AppCompatActivity {
	ToggleButton toggleButton;
	TextView text;
	ConstraintLayout logoutView;
	ConstraintLayout termsView;
	private TextView mEmail;
	private TextView mPhoneNumber;
	private TextView mName;
	CircleImageView mImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		toggleButton = (ToggleButton) findViewById(R.id.switch1);
		text = (TextView) findViewById(R.id.switchScroll);
		logoutView = findViewById(R.id.constraintLayout2);
		mEmail = findViewById(R.id.Email_Id);
		mPhoneNumber = findViewById(R.id.PhoneNumber);
		mName = findViewById(R.id.SettingUserName);
		mImageView = findViewById(R.id.SettingUserProfilePic);


		toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				if(isChecked){
					text.setText(R.string.switch_yes);
				}
				else{
					text.setText(R.string.switch_no);
				}
			}
		});


         logoutView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }
        );
        populateSettingsUI();

	}

	private void populateSettingsUI() {


	}



//	public void closeApplication() {
//        Intent intent = new Intent(getApplicationContext(), Logout.class);
//
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//        startActivity(intent);
//	}



}
