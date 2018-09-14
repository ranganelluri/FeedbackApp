package com.pulsehrm.feedbackapp.Beans

import com.google.gson.annotations.SerializedName

data class ItemsItem(@SerializedName("feedback")
                     val feedback: String = "",
                     @SerializedName("rating")
                     val rating: String = "")