package com.example.myapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4)

        val newsHeadingArray = arrayOf("Heading 1", "Heading 2", "Heading 3", "Heading 4", "Heading 5")

        val newsContentArray = arrayOf("Content 1", "Content 2", "Content 3", "Content 4", "Content 5")



        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for(index in newsHeadingArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index],newsContentArray[index])
            newsArrayList.add(news)
        }

        val myAdapter = MyAdapter(newsArrayList,this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setItemClickListener(object : MyAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(applicationContext,NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageID",newsArrayList[position].newsImage)
                intent.putExtra("content",newsArrayList[position].newContent)
                startActivity(intent)
            }
        })
    }
}