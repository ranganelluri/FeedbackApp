package com.pulsehrm.feedbackapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.pulsehrm.feedbackapp.Beans.CustomerFeedbackBean
import kotlinx.android.synthetic.main.activity_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://192.168.0.247:8084/").build()

        val api = r.create(FeedbackAppAPI::class.java)

        reports.setOnClickListener {

            val call = api.read()

            call.enqueue(object : Callback<CustomerFeedbackBean> {
                override fun onFailure(call: Call<CustomerFeedbackBean>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<CustomerFeedbackBean>?, response: Response<CustomerFeedbackBean>?) {

                    val bean = response!!.body()

                    val list = mutableListOf<String>()

                    val item = bean!!.items

                    for (i in item!!){

                        list.add("Rating : "+i.rating)
                        list.add("Feedback : "+i.feedback)


                    }


                    val myAdapter = ArrayAdapter<String>(this@ReportActivity,android.R.layout.simple_list_item_single_choice)

                    lview.adapter = myAdapter



                }


            })

        }


        }
    }

