package com.example.fragmentapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListFragment : Fragment(R.layout.fragment_list) {

    private val contactsList: MutableList<ContactData> = ArrayList()
    private val textViewsList: MutableList<TextView> = ArrayList()

    private var textview1: TextView? = null
    private var textview2: TextView? = null
    private var textview3: TextView? = null
    private var textview4: TextView? = null
    private var textview5: TextView? = null
    private var textview6: TextView? = null

    companion object {
        const val LIST_FRAG_TAG = "com.example.1.List"

        fun newListFragment(): ListFragment {
            Log.d(LIST_FRAG_TAG, "newList")
            return ListFragment()
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        Log.d(LIST_FRAG_TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LIST_FRAG_TAG, "onCreate")
        addContacts()
    }

    private fun addContacts() {
        contactsList.add(ContactData("Aльфред", "Альтов", "1111111"))
        contactsList.add(ContactData("Борис", "Бетов", "2222222"))
        contactsList.add(ContactData("Виталий", "Витов", "3333333"))
        contactsList.add(ContactData("Георгий", "Громов", "4444444"))
        contactsList.add(ContactData("Денис", "Дробов", "5555555"))
        contactsList.add(ContactData("Егор", "Едров", "6666666"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LIST_FRAG_TAG, "onCreateView")
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        initViews(view)
        return view
    }

    private fun initViews(v: View) {
        textview1 = v.findViewById(R.id.text_1)
        textview2 = v.findViewById(R.id.text_2)
        textview3 = v.findViewById(R.id.text_3)
        textview4 = v.findViewById(R.id.text_4)
        textview5 = v.findViewById(R.id.text_5)
        textview6 = v.findViewById(R.id.text_6)

        if (textViewsList.isNotEmpty()) {
            textViewsList.clear()
        }

        textview1?.let { textViewsList.add(it) }
        textview2?.let { textViewsList.add(it) }
        textview3?.let { textViewsList.add(it) }
        textview4?.let { textViewsList.add(it) }
        textview5?.let { textViewsList.add(it) }
        textview6?.let { textViewsList.add(it) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LIST_FRAG_TAG, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        setTexts()
        initListeners()
        Log.d(LIST_FRAG_TAG, "onStart")
    }

    private fun setTexts() {
        Log.d(LIST_FRAG_TAG, "setTexts: = {${contactsList.size}}")
        for (textview in textViewsList) {
            textview.text = contactsList[textViewsList.indexOf(textview)].toString()
        }
    }

    private fun initListeners() {
        for (textview in textViewsList) {
            textview.setOnClickListener(ContactListener(contactsList[textViewsList.indexOf(textview)]))
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIST_FRAG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIST_FRAG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIST_FRAG_TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LIST_FRAG_TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIST_FRAG_TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LIST_FRAG_TAG, "onDetach")
    }

    inner class ContactListener(private val contactData: ContactData) : View.OnClickListener {
        override fun onClick(p0: View?) {
            val fragment = DetailFragment.newDetailFragment(contactData)
            requireActivity().supportFragmentManager.beginTransaction().run {
                replace(R.id.fragment_container, fragment, "TAG")
                addToBackStack("TAG1")
                commit()
            }
        }
    }
}