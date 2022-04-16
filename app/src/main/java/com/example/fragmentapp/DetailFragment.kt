package com.example.fragmentapp

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment

class DetailFragment : Fragment(R.layout.fragment_detail) {

    var editName: EditText? = null
    var editLastName: EditText? = null
    var editNumber: EditText? = null

    companion object {
        private const val ARGS_NAME = "ARGS_NAME"
        private const val ARGS_LASTNAME = "ARGS_LNAME"
        private const val ARGS_NUMBER = "ARGS_NUMBER"

        fun newDetailFragment(contactData: ContactData): DetailFragment {
            val detailFragment = DetailFragment()
            val args = Bundle()
            args.putString(ARGS_NAME, contactData.name)
            args.putString(ARGS_LASTNAME, contactData.lastName)
            args.putString(ARGS_NUMBER, contactData.number)
            detailFragment.arguments = args

            return detailFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        val bundle = arguments
        bundle?.let {
            Log.d("111", "get")
            setInfo(bundle)
        }
    }

    private fun initViews() {
        editName = view?.findViewById(R.id.edit_name)
        editLastName = view?.findViewById(R.id.edit_lastname)
        editNumber = view?.findViewById(R.id.edit_number)
    }

    private fun setInfo(bundle: Bundle) {
        (bundle.getString(ARGS_NAME))?.let {
            Log.d("111", "get")
            editName?.text = Editable.Factory.getInstance().newEditable(it)
        }
        (bundle.getString(ARGS_LASTNAME))?.let {
            editLastName?.text = Editable.Factory.getInstance().newEditable(it)
        }
        (bundle.getString(ARGS_NUMBER))?.let {
            editNumber?.text = Editable.Factory.getInstance().newEditable(it)
        }
    }
}