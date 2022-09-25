package com.tnodev.gnewsmvi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tnodev.example.Articles
import com.tnodev.gnewsmvi.databinding.NewsItemBinding

class  NewsAdapter : RecyclerView.Adapter<NewsViewHolder>(){

    private  var articles = listOf<Articles>();
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val itemBinding =
            NewsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false);
        return  NewsViewHolder(itemBinding);
    }


    fun  addArticle(articles: List<Articles>){
        this.articles = articles;
        notifyDataSetChanged();
    }
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.bind(articles [position]);
    }

    override fun getItemCount(): Int {
         return  articles.size;
    }


}


class  NewsViewHolder(private  val newsItemBinding: NewsItemBinding)
    : RecyclerView.ViewHolder(newsItemBinding.root)
{
    fun bind(articles: Articles){
        newsItemBinding.title.text = articles.title;
        newsItemBinding.description.text = articles.description;
    }
}

