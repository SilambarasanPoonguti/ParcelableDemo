package com.silambar.parcelabledemo.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.silambar.parcelabledemo.R

/**
 * Created by silambarasan on 16/03/18.
 */

class TempleDetailActivity : AppCompatActivity() {

  public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_temple_detail)
    setupUI()
  }

  private fun setupUI() {

    val title = findViewById<View>(R.id.temple_title) as TextView
    val templeImage = findViewById<View>(R.id.temple_image) as ImageView
    val descriptions = findViewById<View>(R.id.descriptions) as TextView
    val address = findViewById<View>(R.id.address) as TextView

    val temple = intent.getParcelableExtra<Temple>("TEMPLE")
    temple?.let {
      title.text = it.name
      templeImage.setImageResource(it.image)
      descriptions.text = it.templeInfo?.description
      address.text = it.templeInfo?.address
    }
  }
}
