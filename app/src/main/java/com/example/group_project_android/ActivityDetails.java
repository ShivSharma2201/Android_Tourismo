package com.example.group_project_android;

import java.io.Serializable;

public class ActivityDetails implements  Serializable {
    String nameOfActivity;
    String description;
    float starRating;
    String companyName;
    float price;
    String imageName;
    int id;
    long num;



    public ActivityDetails(int id,String nameOfActivity, String description, float starRating, String companyName, float price,String imageName,long num) {
        this.id = id;
        this.nameOfActivity = nameOfActivity;
        this.description = description;
        this.starRating = starRating;
        this.companyName = companyName;
        this.price = price;
        this.imageName = imageName;
        this.num=num;

    }

  /*  public ActivityDetails(Parcel in) {
        id = in.readInt();
        nameOfActivity = in.readString();
        description = in.readString();
        starRating = in.readFloat();
        price = in.readFloat();
        imageName=in.readString();
        companyName = in.readString();
    }*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfActivity() {
        return nameOfActivity;
    }

    public void setNameOfActivity(String nameOfActivity) {
        this.nameOfActivity = nameOfActivity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }/*
    public static final Creator<ActivityDetails> CREATOR = new Creator<ActivityDetails>() {
        @Override
        public ActivityDetails createFromParcel(Parcel in) {
            return new ActivityDetails(in);
        }

        @Override
        public ActivityDetails[] newArray(int size) {
            return new ActivityDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getNameOfActivity());
        parcel.writeFloat(getPrice());
        parcel.writeString(getCompanyName());
        parcel.writeFloat(getStarRating());
        parcel.writeString(getDescription());
        parcel.writeString(getImageName());
        parcel.writeInt(getId());
    }*/
}
