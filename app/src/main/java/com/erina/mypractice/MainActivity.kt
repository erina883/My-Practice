package com.erina.mypractice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.erina.mypractice.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.root)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController: NavController = findNavController(R.id.fragmentContainerView)

        appBarConfiguration = AppBarConfiguration(

            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.chatFragment
            ),drawerLayout
        )

        setupActionBarWithNavController(navController, drawerLayout)

        navView.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.fragmentContainerView)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.homeMenu ->{
                Toast.makeText(this@MainActivity,"Home", Toast.LENGTH_SHORT).show()
            }
            R.id.searchMenu ->{
                Toast.makeText(this@MainActivity,"Search", Toast.LENGTH_SHORT).show()
            }
            R.id.chatMenu ->{
                Toast.makeText(this@MainActivity,"Chat", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)

    }
}