package com.hikerhelper.bushwack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [List.newInstance] factory method to
 * create an instance of this fragment.
 */
class List<T> : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

//    val button = view?.findViewById<Button>(R.id.addButton) as Button


    //Attempts to create a function for the button and set up the list
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fun OnClickListener(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            // Inflate the fragment layout
            val rootView: View = inflater.inflate(R.layout.fragment_list, container, false)
            // Find views by their IDs
            val textViewExample: TextView = rootView.findViewById(R.id.editItemName)
            val buttonExample: Button = rootView.findViewById(R.id.addButton)
            // Set onClickListener for the button
            buttonExample.setOnClickListener { // Handle button click
                textViewExample.setText("Button Clicked!")
            }
            return rootView
        }
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

//            // Inflate the layout for the fragment
//            val view = inflater.inflate(R.layout.fragment_list, container, false)
//
//            // Find the button
//            val button = view.findViewById<Button>(R.id.addButton)
//            var userList = view.findViewById<ListView>(R.id.itemList)
//            var texty = view.findViewById<EditText>(R.id.editItemName)
//            lateinit var actualList: ArrayList<String>
//            actualList.add("Empty?")
//
//            val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
//                view.context,
//                android.R.layout.simple_list_item_checked,
//                actualList.toTypedArray()
//            )
//
//        userList.adapter = adapter
//
//            // Create an OnClickListener object
//            val listener = View.OnClickListener {
//                val item = texty.text.toString()
//
//                // on below line we are checking if item is not empty
//                if (item.isNotEmpty()) {
//                    // on below line we are adding item to our list.
//                    actualList.add(item)
//
//                    // on below line we are notifying adapter
//                    // that data in list is updated to update our list view.
//                    adapter.notifyDataSetChanged()
//                }
//            }
//
//            // Set the OnClickListener on the button
//            button.setOnClickListener(listener)
//
//            return view
//    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment List.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            List<Any>().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}