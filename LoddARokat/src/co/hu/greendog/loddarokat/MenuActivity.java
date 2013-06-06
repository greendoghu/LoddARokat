package co.hu.greendog.loddarokat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MenuActivity extends Activity {
	private AdView adView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_layout);
	    adView = new AdView(this, AdSize.BANNER, "a151af149a8697b");
	    LinearLayout layout = (LinearLayout)findViewById(R.id.adview);
	    layout.addView(adView);
	    adView.loadAd(new AdRequest());
	}
	
	@Override
	  public void onDestroy() {
	    if (adView != null) {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }

}
