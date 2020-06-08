package com.example.viewpager2;

public class OnBoardModel {
    private int ImageView,Header,Description;

    public OnBoardModel(){

    }
    public OnBoardModel(int ImageView, int Header, int Description){
        this.ImageView = ImageView;
        this.Header = Header;
        this.Description = Description;
    }

    public int getImageView() {
        return ImageView;
    }

    public void setImageView(int imageView) {
        ImageView = imageView;
    }

    public int getHeader() {
        return Header;
    }

    public void setHeader(int header) {
        Header = header;
    }

    public int getDescription() {
        return Description;
    }

    public void setDescription(int description) {
        Description = description;
    }
}
