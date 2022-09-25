package com.tnodev.example

import com.google.gson.annotations.SerializedName


data class Source (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)