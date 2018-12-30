package com.example.salih.customlistview1;

public class MobileOS {
  private String name;
  private String version;
  private int img;

  public MobileOS(String name, String version, int img) {
    this.name = name;
    this.version = version;
    this.img = img;
  }

  public String getName() {
    return name;
  }
  public String getVersion() {
    return version;
  }
  public int getImg() {
    return img;
  }
}
