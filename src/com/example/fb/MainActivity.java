package com.example.fb;

import java.io.UnsupportedEncodingException;

import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	SocialAuthAdapter adapter;
	Button fb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adapter = new SocialAuthAdapter(new ResponseListener());
		fb = (Button) findViewById(R.id.fbshare);
		fb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				adapter.authorize(MainActivity.this, Provider.FACEBOOK);
			}
		});
	}

	public class ResponseListener implements DialogListener {

		@Override
		public void onBack() {
			// TODO Auto-generated method stub

		}

		@Override
		public void onCancel() {
			// TODO Auto-generated method stub

		}

		@Override
		public void onComplete(Bundle arg0) {

			try {
				adapter.updateStory(
						"Download Poular Number Arranger Game/Puzzle for Android.",
						"Number Arranger (Game/Puzzle)",
						"Click here to download Number Arranger from Google Play-Store.",
						"Number Arranger is kind of mathamatical Game/Puzzle who helps you to sharp your memory and improve your thinking ability. Download this interesting game from Google Play-Store and play with it. Developed By - Vikrant Alekar.",
						"https://play.google.com/store/search?q=com.vikrant.numberarranger",
						"https://play.google.com/store/search?q=com.vikrant.allinonesmsbanking",// imge
																								// link
						new MessageListener());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onError(SocialAuthError arg0) {
			// TODO Auto-generated method stub

		}
	}

	// To get status of message after authentication
	private final class MessageListener implements SocialAuthListener<Integer> {

		@Override
		public void onError(SocialAuthError arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onExecute(String arg0, Integer t) {
			// TODO Auto-generated method stub

			Integer status = t;
			if (status.intValue() == 200 || status.intValue() == 201
					|| status.intValue() == 204)
				Toast.makeText(getApplicationContext(), "Message posted",
						Toast.LENGTH_LONG).show();
			else
				Toast.makeText(getApplicationContext(), "Message not posted",
						Toast.LENGTH_LONG).show();

		}

	}

}
