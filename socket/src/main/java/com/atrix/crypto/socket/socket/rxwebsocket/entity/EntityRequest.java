package com.atrix.crypto.socket.socket.rxwebsocket.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Evgeniy Solovev
 * Date: 16.08.2018
 * Email: solevur@gmail.com
 */
public class EntityRequest {

    @SerializedName("type")
    public String type;

    @SerializedName("symbol")
    public String symbol;

    @SerializedName("source")
    public Integer source;
}
