package com.pulsehrm.feedbackapp.Beans

import com.google.gson.annotations.SerializedName

data class InsertResponseBean(@SerializedName("MESSAGE")
                              val message: String = "")