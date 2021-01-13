package com.rs132studio.fragment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rs132studio.fragment.Model.Contacts
import com.rs132studio.fragment.R
import kotlinx.android.synthetic.main.activity_collapse.*

class CollapseActivity : AppCompatActivity() {

    companion object{
        val CONTACT_DETAILS = "contact details"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapse)

        val contactInfo = intent.getSerializableExtra(CONTACT_DETAILS) as Contacts
        val dp_pic = contactInfo.cImages
        val contact_name = contactInfo.name
        val contact_description = contactInfo.description

        tool_name.title = contact_name
        tool_desc.text = contact_description
        profile_pic.setImageResource(dp_pic)

    }
}