package com.rahmi.project_uas.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TVResponse(
    @SerializedName("results")
    val tv : List<TV>

) : Parcelable {
    constructor() : this(mutableListOf())
}
