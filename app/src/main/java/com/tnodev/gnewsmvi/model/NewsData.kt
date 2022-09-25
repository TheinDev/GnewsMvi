package com.tnodev.example

import com.google.gson.annotations.SerializedName


data class Article (

  @SerializedName("totalArticles" )
  var totalArticles : Int? ,

  @SerializedName("articles"      )
  var articles      : ArrayList<Articles>,

)