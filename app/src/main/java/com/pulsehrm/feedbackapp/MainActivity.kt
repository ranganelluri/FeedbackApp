package com.pulsehrm.feedbackapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.pulsehrm.feedbackapp.Beans.InsertResponseBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        report.setOnClickListener {
            val reportActivity = Intent(this, ReportActivity::class.java)
            startActivity(reportActivity)

            var r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://192.168.0.247:8084/").build()

            var api = r.create(FeedbackAppAPI::class.java)

            var fed = findViewById<EditText>(R.id.et)

            if (fed != null) {

                submit.setOnClickListener {


                    var ratingval = findViewById<RatingBar>(R.id.rating)

                    if (ratingval != null && et.text != null) {

                        rValue.text = ratingval.rating.toString()

                        var msg = ratingval.rating.toString()

                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()

                        var call = api.insert(ratingval.rating.toString(), et.text.toString())


                        call.enqueue(object : Callback<InsertResponseBean> {
                            override fun onResponse(call: Call<InsertResponseBean>?,
                                                    response: Response<InsertResponseBean>?) {

                                var bean = response!!.body()
                                if (bean != null) {
                                    Toast.makeText(this@MainActivity,
                                            "no error", Toast.LENGTH_LONG).show()
                                }
                            }

                            override fun onFailure(call: Call<InsertResponseBean>?, t: Throwable?) {

                            }
                        })


                    }

                }

            }

        }
    }
}
