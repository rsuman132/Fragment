package com.rs132studio.fragment.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.rs132studio.fragment.Adapter.ContactAdapter
import com.rs132studio.fragment.Activity.CollapseActivity
import com.rs132studio.fragment.Adapter.BottomFragmentAdapter
import com.rs132studio.fragment.Model.Contacts
import com.rs132studio.fragment.R
import kotlinx.android.synthetic.main.activity_main.*

class Fragment_1 : Fragment(), ContactAdapter.OnItemClicked{

    lateinit var contactRecyclerView: RecyclerView
    private val list = ArrayList<Contacts>()
    private val adapter : ContactAdapter = ContactAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactRecyclerView = view.findViewById(R.id.contact_RecyclerView)
        val adapter = ContactAdapter(list, this)
        contactRecyclerView.layoutManager = LinearLayoutManager(activity)
        contactRecyclerView.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list.add(Contacts("Suman", "This Contact is belongs to Suman", R.drawable.ic_account))
        list.add(Contacts("Ligen", "This Contact is belongs to Ligen", R.drawable.ic_baseline_accessibility))
        list.add(Contacts("Benz", "This Contact is belongs to Benz", R.drawable.ic_airline_seat))
        list.add(Contacts("Japhagar", "This Contact is belongs to Japhagar", R.drawable.ic_airline_seat_recline))
        list.add(Contacts("Ebenezer", "This Contact is belongs to Ebenezer", R.drawable.ic_how))
        list.add(Contacts("Tamil", "This Contact is belongs to Tamil", R.drawable.ic_bathtub))
        list.add(Contacts("Dinesh", "This Contact is belongs to Dinesh", R.drawable.ic_camera_front))
        list.add(Contacts("Keshav", "This Contact is belongs to Keshav", R.drawable.ic_bike))
        list.add(Contacts("Berarak rays", "This Contact is belongs to Berarak rays", R.drawable.ic_run))
        list.add(Contacts("Android", "This Contact is belongs to Android", R.drawable.ic_android))
        list.add(Contacts("Developer", "This Contact is belongs to Developer", R.drawable.ic_emoji_transportation))
        adapter.notifyDataSetChanged()
    }


    override fun onItemDetailsClicked(position: Int) {

        val cnts = list[position]
        val intent = Intent(activity, CollapseActivity::class.java)
            intent.putExtra(CollapseActivity.CONTACT_DETAILS, cnts)
        activity!!.startActivity(intent)
    }

}