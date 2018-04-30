package com.silambar.parcelabledemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.silambar.parcelabledemo.kotlin.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private var titles = ArrayList<String>()
  private var desc = ArrayList<String>()
  private var address = ArrayList<String>()
  private var templeImages = ArrayList<Int>()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    titles = resources.getStringArray(R.array.temple_titles).toCollection(ArrayList())
    desc = resources.getStringArray(R.array.temple_desc).toCollection(ArrayList())
    address = resources.getStringArray(R.array.temple_address).toCollection(ArrayList())
    templeImages = intArrayOf(R.drawable.temple2_brihadeeswarar, R.drawable.temple1_meenakshiamman,
        R.drawable.temple3_nataraja, R.drawable.temple4_palani, R.drawable.temple5_kailasanathar,
        R.drawable.temple6_annamalaiyar, R.drawable.temple7_ramanathaswamy,
        R.drawable.temple8_tiruchendur,
        R.drawable.temple9_ekambareswarar, R.drawable.temple10_la_saleth,
        R.drawable.temple11_gorippalayam_dargah).toCollection(ArrayList())

    parcelable_single_object.setOnClickListener {
      val intent = Intent(this@MainActivity, TempleDetailActivity::class.java)
      intent.putExtra("TEMPLE", getTempleData(0))
      startActivity(intent)
    }

    parcelable_list_objects.setOnClickListener {
      val intent = Intent(this@MainActivity, TempleListActivity::class.java)
      intent.putParcelableArrayListExtra("TEMPLE_LIST", getTemplesData())
      startActivity(intent)
    }
  }

  private fun getTemplesData(): ArrayList<Temple> {
    val temples = ArrayList<Temple>()
    titles.indices.mapTo(temples) { getTempleData(it) }
    return temples
  }

  private fun getTempleData(id: Int): Temple {
    val temple = Temple()
    temple.name = titles[id]
    temple.image = templeImages[id]
    val templeInfo = TempleInfo()
    templeInfo.address = address[id]
    templeInfo.description = desc[id]
    temple.templeInfo = templeInfo
    return temple
  }
}
