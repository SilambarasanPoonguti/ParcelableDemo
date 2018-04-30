package com.silambar.parcelabledemo.java;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by silambarasan on 13/03/18.
 */

public class Temple implements Parcelable {

  private String name;
  private int image;
  private TempleInfo info;

  public Temple(){}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getImage() {
    return image;
  }

  public TempleInfo getInfo() {
    return info;
  }

  public void setInfo(TempleInfo info) {
    this.info = info;
  }

  public void setImage(int thumpnail) {
    this.image = thumpnail;
  }

  protected Temple(Parcel in) {
    name = in.readString();
    info = in.readParcelable(TempleInfo.class.getClassLoader());
    image = in.readInt();
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeParcelable(info, flags); // Add inner class
    dest.writeInt(image);
  }

  @Override public int describeContents() {
    return 0;
  }

  public static final Creator<Temple> CREATOR = new Creator<Temple>() {
    @Override public Temple createFromParcel(Parcel in) {
      return new Temple(in);
    }

    @Override public Temple[] newArray(int size) {
      return new Temple[size];
    }
  };
}
