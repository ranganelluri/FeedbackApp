package com.pulsehrm.feedbackapp

import com.pulsehrm.feedbackapp.Beans.CustomerFeedbackBean
import com.pulsehrm.feedbackapp.Beans.InsertResponseBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FeedbackAppAPI {

         @POST("ords/pulse_dev/cf/Feedbak_Data/P_RATING/{P_RATING}/P_FEEDBACK/{P_FEEDBACK}")
     fun insert(@Path("P_RATING")P_RATING:String,
               @Path("P_FEEDBACK")P_FEEDBACK:String) : Call<InsertResponseBean>


          @GET("ords/pulse_dev/cf/Feedbak_Data")
      fun read() : Call<CustomerFeedbackBean>
}