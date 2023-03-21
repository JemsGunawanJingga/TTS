package edu.uksw.fti.pam.acitivityintent.models

import com.google.gson.annotations.SerializedName

data class TodosModel(
    @SerializedName("nama")
    var nama: String,

    @SerializedName("nik")
    var nik: String,

    @SerializedName("title")
    var title: String,


)
