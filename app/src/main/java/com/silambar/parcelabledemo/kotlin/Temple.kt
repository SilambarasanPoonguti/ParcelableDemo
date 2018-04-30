package com.silambar.parcelabledemo.kotlin

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

/**
 * Created by silambarasan on 13/03/18.
 */

class Temple : Parcelable {

  var name: String? = null
  var image: Int = 0
  var templeInfo: TempleInfo? = null

  constructor() {}

  protected constructor(parcel: Parcel) {
    name = parcel.readString()
    templeInfo = parcel.readParcelable(TempleInfo::class.java.classLoader)
    image = parcel.readInt()
  }

  override fun writeToParcel(dest: Parcel, flags: Int) {
    dest.writeString(name)
    dest.writeParcelable(templeInfo, flags) // Add inner class
    dest.writeInt(image)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<Temple> {
    override fun createFromParcel(parcel: Parcel): Temple {
      return Temple(parcel)
    }

    override fun newArray(size: Int): Array<Temple?> {
      return arrayOfNulls(size)
    }
  }
}
