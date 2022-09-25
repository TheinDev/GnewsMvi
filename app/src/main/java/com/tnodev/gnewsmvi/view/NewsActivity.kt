package com.tnodev.gnewsmvi.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.tnodev.gnewsmvi.NewsIntent
import com.tnodev.gnewsmvi.NewsStates
import com.tnodev.gnewsmvi.R
import com.tnodev.gnewsmvi.databinding.ActivityNewsBinding
import com.tnodev.gnewsmvi.viewmodel.NewsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNewsBinding
    private val newsViewModel: NewsViewModel by viewModels()
    private var newsAdapter = NewsAdapter();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setSupportActionBar(binding.toolbar)



        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(context);
            setHasFixedSize(true)
            adapter = newsAdapter;

        }

        lifecycleScope.launch {

            newsViewModel.newsChannel.send(NewsIntent.TopHeadLinesIntent);
        }

        lifecycleScope.launch {
            lifecycleScope.launchWhenStarted {
                newsViewModel.newsStates.collect {

                    when(it){
                        is NewsStates.Success -> {
                            binding.progressBar.visibility = View.GONE
                            newsAdapter.addArticle(it.news.articles)
                        }
                        is NewsStates.Error -> {
                            binding.progressBar.visibility = View.GONE
                        }
                        is NewsStates.Loading ->{
                            binding.progressBar.visibility = View.VISIBLE
                        }
                    }
                }

            }
        }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}