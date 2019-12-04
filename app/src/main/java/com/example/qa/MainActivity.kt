package com.example.qa

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener{
            val intent = Intent(this, AddQuestion::class.java)
            this.startActivity(intent)
        }

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }*/

        val posts: ArrayList<Post> = ArrayList()
        addDummyPosts(posts)
        var adapter = PostAdapter(this, posts)
        var recycler_view: RecyclerView = findViewById(R.id.recycler_view)
        var layout_manager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layout_manager
        recycler_view.adapter = adapter
    }

    fun addDummyPosts(posts: ArrayList<Post>) {
        posts.add(Post("My first post!", "2000, October 0"))
        posts.add(Post("no", "2000, October 1"))
        posts.add(Post(":0", "2000, October 2"))
        posts.add(Post("My first post!", "2000, October 0"))
        posts.add(Post("no", "2000, October 1"))
        posts.add(Post(":0", "2000, October 2"))
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
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
