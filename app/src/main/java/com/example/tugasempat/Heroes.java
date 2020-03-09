package com.example.tugasempat;

import android.os.Parcel;
import android.os.Parcelable;

public class Heroes implements Parcelable {
    private String heroName, heroDesc;
    private int heroImage;

    public Heroes() { }

    protected Heroes(Parcel in) {
        heroName = in.readString();
        heroDesc = in.readString();
        heroImage = in.readInt();
    }


    public static final Creator<Heroes> CREATOR = new Creator<Heroes>() {
        @Override
        public Heroes createFromParcel(Parcel in) {
            return new Heroes(in);
        }

        @Override
        public Heroes[] newArray(int size) {
            return new Heroes[size];
        }
    };

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDesc() {
        return heroDesc;
    }

    public void setHeroDesc(String heroDesc) {
        this.heroDesc = heroDesc;
    }

    public int getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(int heroImage) {
        this.heroImage = heroImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(heroName);
        dest.writeString(heroDesc);
        dest.writeInt(heroImage);
    }
}
