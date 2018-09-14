package com.pulsehrm.feedbackapp.Beans

import com.google.gson.annotations.SerializedName

data class CustomerFeedbackBean(@SerializedName("next")
                                val next: Next,
                                @SerializedName("items")
                                val items: List<ItemsItem>?)