package com.tnodev.example

import com.google.gson.annotations.SerializedName


data class NewsData (

  @SerializedName("totalArticles" )
  var totalArticles : Int? ,

  @SerializedName("articles"      )
  var articles      : ArrayList<Articles>,

)