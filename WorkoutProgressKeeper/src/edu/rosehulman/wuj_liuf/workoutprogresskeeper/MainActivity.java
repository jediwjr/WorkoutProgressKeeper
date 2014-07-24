package edu.rosehulman.wuj_liuf.workoutprogresskeeper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private static final String PREFS = "PREFS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		((Button) findViewById(R.id.start_working_button))
				.setOnClickListener(this);
		((Button) findViewById(R.id.progress_button)).setOnClickListener(this);
		((Button) findViewById(R.id.plan_button)).setOnClickListener(this);

	}

	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences prefs = getSharedPreferences(PREFS,
				Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		// editor.putInt(KEY_NUM_BUTTONS, mNUmButton);
		editor.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {

		case R.id.start_working_button:
			Log.d("LOM", "start_working_button clicked");
			Intent startWorkingIntent = new Intent(this,
					WorkingOutActivity.class);
			// playIntent.putExtra();

			startActivity(startWorkingIntent);

			break;

		case R.id.progress_button:
			Log.d("LOM", "progress_button clicked");
			Intent progressIntent = new Intent(this, ProgressActivity.class);
			// playIntent.putExtra();
			startActivity(progressIntent);

			break;

		case R.id.plan_button:
			Log.d("LOM", "plan_button clicked");
			Intent planIntent = new Intent(this, PlansActivity.class);
			// playIntent.putExtra();
			startActivity(planIntent);

			break;

		}
	}
}
