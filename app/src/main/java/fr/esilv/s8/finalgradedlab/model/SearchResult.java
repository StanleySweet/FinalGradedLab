
package fr.esilv.s8.finalgradedlab.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class SearchResult implements Serializable, Parcelable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("items")
    @Expose
    private Items items = null;
    public final static Parcelable.Creator<SearchResult> CREATOR = new Creator<SearchResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SearchResult createFromParcel(Parcel in) {
            SearchResult instance = new SearchResult();
            instance.kind = ((String) in.readValue((String.class.getClassLoader())));
            instance.etag = ((String) in.readValue((String.class.getClassLoader())));
            instance.nextPageToken = ((String) in.readValue((String.class.getClassLoader())));
            instance.regionCode = ((String) in.readValue((String.class.getClassLoader())));
            instance.pageInfo = ((PageInfo) in.readValue((PageInfo.class.getClassLoader())));
            in.readList(instance.items, (Item.class.getClassLoader()));
            return instance;
        }

        public SearchResult[] newArray(int size) {
            return (new SearchResult[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3871101758703921395L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchResult() {
    }

    /**
     * 
     * @param regionCode
     * @param etag
     * @param items
     * @param pageInfo
     * @param nextPageToken
     * @param kind
     */
    public SearchResult(String kind, String etag, String nextPageToken, String regionCode, PageInfo pageInfo, Items items) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.nextPageToken = nextPageToken;
        this.regionCode = regionCode;
        this.pageInfo = pageInfo;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeValue(etag);
        dest.writeValue(nextPageToken);
        dest.writeValue(regionCode);
        dest.writeValue(pageInfo);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
