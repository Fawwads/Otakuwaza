package com.fawwad.otakuwaza

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            val activityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, btn, "button")
            startActivity(intent, activityOptionsCompat.toBundle())
        }

    }
}
