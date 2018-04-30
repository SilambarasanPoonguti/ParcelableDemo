package com.silambar.parcelabledemo.java;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.silambar.parcelabledemo.R;
import com.silambar.parcelabledemo.java.TempleAdapter.OnTempleClick;
import java.util.ArrayList;

/**
 * Created by silambarasan on 16/03/18.
 */

public class TempleListActivity extends AppCompatActivity {

  private RecyclerView recyclerView;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_temple_list);
    setupUI();
  }

  private void setupUI() {
    recyclerView = (RecyclerView) findViewById(R.id.temple_list);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setHasFixedSize(true);
    setupAdapter();
  }

  private void setupAdapter() {
    ArrayList<Temple> temples = getIntent().getParcelableArrayListExtra("TEMPLE_LIST");
    if (temples != null) {
      TempleAdapter adapter = new TempleAdapter(temples);
      adapter.setClickListener(onTempleClick);
      recyclerView.setAdapter(adapter);
    }
  }

  private OnTempleClick onTempleClick = new OnTempleClick() {
    @Override public void onClick(View view, Temple temple, int position) {
      Toast.makeText(TempleListActivity.this, "Click " + temple.getName(), Toast.LENGTH_SHORT)
          .show();

      Intent intent = new Intent(TempleListActivity.this, TempleDetailActivity.class);
      intent.putExtra("TEMPLE", temple);
      startActivity(intent);
    }
  };
}
