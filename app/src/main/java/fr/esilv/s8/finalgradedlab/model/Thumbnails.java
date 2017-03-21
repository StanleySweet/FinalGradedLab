
package fr.esilv.s8.finalgradedlab.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Thumbnails implements Serializable, Parcelable
{

    @SerializedName("default")
    @Expose
    private Default _default;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("high")
    @Expose
    private High high;
    public final static Parcelable.Creator<Thumbnails> CREATOR = new Creator<Thumbnails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Thumbnails createFromParcel(Parcel in) {
            Thumbnails instance = new Thumbnails();
            instance._default = ((Default) in.readValue((Default.class.getClassLoader())));
            instance.medium = ((Medium) in.readValue((Medium.class.getClassLoader())));
            instance.high = ((High) in.readValue((High.class.getClassLoader())));
            return instance;
        }

        public Thumbnails[] newArray(int size) {
            return (new Thumbnails[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7246271329604379539L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Thumbnails() {
    }

    /**
     * 
     * @param _default
     * @param high
     * @param medium
     */
    public Thumbnails(Default _default, Medium medium, High high) {
        super();
        this._default = _default;
        this.medium = medium;
        this.high = high;
    }

    public Default getDefault() {
        return _default;
    }

    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_default);
        dest.writeValue(medium);
        dest.writeValue(high);
    }

    public int describeContents() {
        return  0;
    }

}
