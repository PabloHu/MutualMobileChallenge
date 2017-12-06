package mobile.huaman.mutualmobile.modelRecipeDisplay;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pablo on 11/29/2017.
 */

public class ModelRecipeDisplay implements Parcelable {
    String title;
    String recipeImageUrl;
    String ingredients;
    String sourceInfo;
    String Url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getRecipeImageUrl() {
        return recipeImageUrl;
    }

    public void setRecipeImageUrl(String recipeImageUrl) {
        this.recipeImageUrl = recipeImageUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(String sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public static Creator<ModelRecipeDisplay> getCREATOR() {
        return CREATOR;
    }

    public ModelRecipeDisplay(String title, String recipeImageUrl, String ingredients, String sourceInfo, String url) {
        this.title = title;
        this.recipeImageUrl = recipeImageUrl;
        this.ingredients = ingredients;
        this.sourceInfo = sourceInfo;
        Url = url;
    }

    public ModelRecipeDisplay() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.recipeImageUrl);
        dest.writeString(this.ingredients);
        dest.writeString(this.sourceInfo);
        dest.writeString(this.Url);
    }

    protected ModelRecipeDisplay(Parcel in) {
        this.title = in.readString();
        this.recipeImageUrl = in.readString();
        this.ingredients = in.readString();
        this.sourceInfo = in.readString();
        this.Url = in.readString();
    }

    public static final Creator<ModelRecipeDisplay> CREATOR = new Creator<ModelRecipeDisplay>() {
        @Override
        public ModelRecipeDisplay createFromParcel(Parcel source) {
            return new ModelRecipeDisplay(source);
        }

        @Override
        public ModelRecipeDisplay[] newArray(int size) {
            return new ModelRecipeDisplay[size];
        }
    };
}
