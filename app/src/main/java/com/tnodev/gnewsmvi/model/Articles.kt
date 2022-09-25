package com.tnodev.example

import com.google.gson.annotations.SerializedName


data class Articles (

  @SerializedName("title"       )
  var title       : String? ,

  @SerializedName("description" )
  var description : String? ,

  @SerializedName("content"     )
  var content     : String? ,

  @SerializedName("url"         )
  var url         : String? ,

  @SerializedName("image"       )
  var image       : String?,

  @SerializedName("publishedAt" )
  var publishedAt : String? ,

  @SerializedName("source"      )
  var source      : Source? = Source()

)