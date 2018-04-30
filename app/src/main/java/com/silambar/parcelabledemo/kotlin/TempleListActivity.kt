package com.silambar.parcelabledemo.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.silambar.parcelabledemo.R
import com.silambar.parcelabledemo.kotlin.TempleAdapter.OnTempleClick

/**
 * Created by silambarasan on 16/03/18.
 */

class TempleListActivity : AppCompatActivity() {

  private var recyclerView: RecyclerView? = null

  public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_temple_list)
    setupUI()
  }

  private fun setupUI() {
    recyclerView = findViewById<View>(R.id.temple_list) as RecyclerView
    recyclerView?.layoutManager = LinearLayoutManager(this)
    recyclerView?.setHasFixedSize(true)
    setupAdapter()
  }

  private fun setupAdapter() {
    val temples = intent.getParcelableArrayListExtra<Temple>("TEMPLE_LIST")
    temples?.let {
      val adapter = TempleAdapter(it)
      adapter.setClickListener(onTempleClick)
      recyclerView?.adapter = adapter
    }
  }

  private val onTempleClick = object : OnTempleClick {
    override fun onClick(view: View, temple: Temple, position: Int) {
      Toast.makeText(this@TempleListActivity, "Click " + temple.name, Toast.LENGTH_SHORT)
          .show()

      val intent = Intent(this@TempleListActivity, TempleDetailActivity::class.java)
      intent.putExtra("TEMPLE", temple)
      startActivity(intent)
    }
  }
}
