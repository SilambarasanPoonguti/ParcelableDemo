package com.silambar.parcelabledemo.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.silambar.parcelabledemo.R;

/**
 * Created by silambarasan on 16/03/18.
 */

public class TempleDetailActivity extends AppCompatActivity {

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_temple_detail);
    setupUI();
  }

  private void setupUI() {

    TextView title = (TextView) findViewById(R.id.temple_title);
    ImageView temple_image = (ImageView) findViewById(R.id.temple_image);
    TextView descriptions = (TextView) findViewById(R.id.descriptions);
    TextView address = (TextView) findViewById(R.id.address);

    Temple temple = getIntent().getParcelableExtra("TEMPLE");
    if (temple != null) {
      title.setText(temple.getName());
      temple_image.setImageResource(temple.getImage());
      descriptions.setText(temple.getInfo().getDescription());
      address.setText(temple.getInfo().getAddress());
    }
  }
}
