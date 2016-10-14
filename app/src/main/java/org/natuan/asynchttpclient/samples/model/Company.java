package org.natuan.asynchttpclient.samples.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 10/13/2016
 */
public class Company {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;
    @SerializedName("bs")
    @Expose
    private String bs;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The catchPhrase
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     *
     * @param catchPhrase
     * The catchPhrase
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     *
     * @return
     * The bs
     */
    public String getBs() {
        return bs;
    }

    /**
     *
     * @param bs
     * The bs
     */
    public void setBs(String bs) {
        this.bs = bs;
    }
}
