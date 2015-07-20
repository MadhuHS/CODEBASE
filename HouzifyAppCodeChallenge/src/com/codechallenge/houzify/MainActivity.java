package com.codechallenge.houzify;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridView;

import com.codechallenge.adapters.GridViewAdapter;
import com.codechallenge.helper.AppUtils;
import com.codechallenge.helper.Constants;

public class MainActivity extends Activity {

	private AppUtils utils;
	private ArrayList<String> imagePaths = new ArrayList<String>();
	private GridViewAdapter adapter;
	private GridView gridView;
	private int columnWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gridView = (GridView) findViewById(R.id.grid_view);

		utils = new AppUtils(this);

		// Initilizing Grid View
		InitilizeGridLayout();

		// loading all image paths from SD card
		imagePaths = utils.getfilepaths();

		// Gridview adapter
		adapter = new GridViewAdapter(MainActivity.this, imagePaths,columnWidth);

		// setting grid view adapter
		gridView.setAdapter(adapter);
	}

	private void InitilizeGridLayout() {
		Resources r = getResources();
		float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				Constants.GRID_IMAGES_PADDING, r.getDisplayMetrics());

		columnWidth = (int) ((utils.getScreenWidth() - ((Constants.NUM_OF_COLMNS + 1) * padding)) / Constants.NUM_OF_COLMNS);

		gridView.setNumColumns(Constants.NUM_OF_COLMNS);
		gridView.setColumnWidth(columnWidth);
		gridView.setStretchMode(GridView.NO_STRETCH);
		gridView.setPadding((int) padding, (int) padding, (int) padding,
				(int) padding);
		gridView.setHorizontalSpacing((int) padding);
		gridView.setVerticalSpacing((int) padding);
	}
}
