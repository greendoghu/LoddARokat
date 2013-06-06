package co.hu.greendog.loddarokat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MenuActivity extends Activity {
	private AdView adView;
	Button game, rules, exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_layout);
		
		adView = new AdView(this, AdSize.BANNER, "a151af149a8697b");
		LinearLayout layout = (LinearLayout) findViewById(R.id.adview);
		game = (Button) findViewById(R.id.gameButton);
		
		layout.addView(adView);
		adView.loadAd(new AdRequest());
		
		game.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MenuActivity.this,LevelSelectActivity.class));
			}
		});
	}

	@Override
	public void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}

}
