package com.silambar.parcelabledemo.java;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by silambarasan on 13/03/18.
 */

public class TempleInfo implements Parcelable {

  private String address;
  private String description;

  public TempleInfo(){}

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  protected TempleInfo(Parcel in) {
    address = in.readString();
    description = in.readString();
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(address);
    dest.writeString(description);
  }

  @Override public int describeContents() {
    return 0;
  }

  public static final Creator<TempleInfo> CREATOR = new Creator<TempleInfo>() {
    @Override public TempleInfo createFromParcel(Parcel in) {
      return new TempleInfo(in);
    }

    @Override public TempleInfo[] newArray(int size) {
      return new TempleInfo[size];
    }
  };
}
