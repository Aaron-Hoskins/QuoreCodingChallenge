package com.example.app.quorecodingchallenge.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.quorecodingchallenge.R
import com.example.app.quorecodingchallenge.model.news.Article
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.news_list_item.*
import kotlinx.android.synthetic.main.news_list_item.tvAuthor

import kotlinx.android.synthetic.main.news_list_item.tvTitle


class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val article = intent.extras?.getParcelable<Article?>("article")
        if(article != null) {
            tvAuthor.text = article.author
            tvTitle.text = article.title
            wvArticle.loadUrl(article.url)
        }
    }
}
