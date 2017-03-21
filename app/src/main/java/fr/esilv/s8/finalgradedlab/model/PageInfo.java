
package fr.esilv.s8.finalgradedlab.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class PageInfo implements Serializable, Parcelable
{

    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("resultsPerPage")
    @Expose
    private Integer resultsPerPage;
    public final static Parcelable.Creator<PageInfo> CREATOR = new Creator<PageInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PageInfo createFromParcel(Parcel in) {
            PageInfo instance = new PageInfo();
            instance.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.resultsPerPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public PageInfo[] newArray(int size) {
            return (new PageInfo[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7585829244431497138L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PageInfo() {
    }

    /**
     * 
     * @param totalResults
     * @param resultsPerPage
     */
    public PageInfo(Integer totalResults, Integer resultsPerPage) {
        super();
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalResults);
        dest.writeValue(resultsPerPage);
    }

    public int describeContents() {
        return  0;
    }

}
