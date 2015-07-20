package com.codechallenge.houzify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.codechallenge.adapters.FullScreenAdapter;
import com.codechallenge.helper.AppUtils;

public class FullScreenViewActivity extends Activity {

	private AppUtils utils;
	private FullScreenAdapter adapter;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen_view);

		viewPager = (ViewPager) findViewById(R.id.pager);

		utils = new AppUtils(getApplicationContext());

		Intent i = getIntent();
		int position = i.getIntExtra("position", 0);

		//fix it
		adapter = new FullScreenAdapter(FullScreenViewActivity.this,utils.getfilepaths());

		viewPager.setAdapter(adapter);

		// displaying selected image first
		viewPager.setCurrentItem(position);
	}
}
