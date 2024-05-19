package com.hikerhelper.bushwack

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.RelativeLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.getOrAddAdapter
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.hikerhelper.bushwack.R.id.*
import com.hikerhelper.bushwack.ui.theme.BushwackTheme
import com.hikerhelper.bushwack.R.layout.fragment_list

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //Initialize our variables
    private lateinit var drawerLayout: DrawerLayout
    /*private lateinit var userList: ListView
    private lateinit var addButtony: Button
    private lateinit var editText: EditText
    private lateinit var listy: ArrayList<String>*/
    private lateinit var linLayli: LinearLayout
    private lateinit var relLayli: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sets up the full layout, including fragments, and activates it
        drawerLayout = findViewById(drawer_layout)

        //linLayli = findViewById<LinearLayout>(linLay)
        /*relLayli = findViewById<RelativeLayout>(listContainer)
        userList = findViewById(itemList)
        addButtony = findViewById(addButton)
        editText = findViewById(editItemName)
        listy = ArrayList()*/

        //Sets up the toolbar above and activates it
        val toolbar = findViewById<Toolbar>(toolbar)
        setSupportActionBar(toolbar)

        //sets up the sidemenu layout and activates it
        val navigationView = findViewById<NavigationView>(nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        //Creates the way to open the side menu
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        /*val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this@MainActivity,
            android.R.layout.simple_list_item_checked,
            listy.toTypedArray()
        )

        userList.adapter = adapter

        addButtony.setOnClickListener {
            val item = editText.text.toString()
            if(item.isNotEmpty()){
                listy.add(item)
                adapter.notifyDataSetChanged()
            }
        }*/

        //Checks to see if there is a saved instance of the app already running
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(fragment_cont, Home()).commit()
            navigationView.setCheckedItem(nav_home)
        }
    }

    //(UNUSED) Makes the Home page visible.
    fun homeVisible(){
        linLayli.setVisibility(View.VISIBLE)
        relLayli.setVisibility(View.GONE)
    }

    //(UNUSED) Makes the List page visible.
    fun listVisible(){
        linLayli.setVisibility(View.GONE)
        relLayli.setVisibility(View.VISIBLE)
    }

    //Controls the menu
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            nav_home -> //homeVisible()
                supportFragmentManager.beginTransaction()
                .replace(fragment_cont, Home()).commit()
            nav_list -> //listVisible()
                supportFragmentManager.beginTransaction()
                .replace(fragment_cont, List<Any>()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    //Overrides the onClick option for the button
//    override fun onClick(view: View?) {
//        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
//            this@MainActivity,
//            android.R.layout.simple_list_item_checked,
//            list as ArrayList<String?>
//        )
//
//        val  texty: EditText = findViewById(R.id.editItemName)
//        val item = texty.text.toString()
//        println(texty.text.toString())
//        if (item.isNotEmpty()) {
//            list.add(item)
//        }


    //}

    //Controls what happens when the back button is pressed
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

//UNUSED FUNCTIONS THAT MAY COME IN HANDY IN THE FUTURE
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BushwackTheme {
        Greeting("name")
    }
}