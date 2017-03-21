
package fr.esilv.s8.finalgradedlab.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
public class Id implements Serializable, Parcelable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("channelId")
    @Expose
    private String channelId;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    public final static Parcelable.Creator<Id> CREATOR = new Creator<Id>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Id createFromParcel(Parcel in) {
            Id instance = new Id();
            instance.kind = ((String) in.readValue((String.class.getClassLoader())));
            instance.channelId = ((String) in.readValue((String.class.getClassLoader())));
            instance.videoId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Id[] newArray(int size) {
            return (new Id[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1311546634887685945L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Id() {
    }

    /**
     * 
     * @param channelId
     * @param videoId
     * @param kind
     */
    public Id(String kind, String channelId, String videoId) {
        super();
        this.kind = kind;
        this.channelId = channelId;
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeValue(channelId);
        dest.writeValue(videoId);
    }

    public int describeContents() {
        return  0;
    }

}
