package com.silambar.parcelabledemo.kotlin

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

/**
 * Created by silambarasan on 13/03/18.
 */

class TempleInfo : Parcelable {

  var address: String? = null
  var description: String? = null

  constructor() {}

  protected constructor(parcel: Parcel) {
    address = parcel.readString()
    description = parcel.readString()
  }

  override fun writeToParcel(dest: Parcel, flags: Int) {
    dest.writeString(address)
    dest.writeString(description)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Creator<TempleInfo> {
    override fun createFromParcel(parcel: Parcel): TempleInfo {
      return TempleInfo(parcel)
    }

    override fun newArray(size: Int): Array<TempleInfo?> {
      return arrayOfNulls(size)
    }
  }
}
