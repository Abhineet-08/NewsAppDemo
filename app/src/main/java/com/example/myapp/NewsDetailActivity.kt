package com.example.myapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("content")
        val newsImage = intent.getIntExtra("imageID", R.drawable.pic0)

        val headingTV = findViewById<TextView>(R.id.newsHeading)
        val headingIV = findViewById<ImageView>(R.id.newsImage)
        val contentTV = findViewById<TextView>(R.id.newsContent)

        headingTV.text = heading
        contentTV.text = newsContent
        headingIV.setImageResource(newsImage)
    }
}
