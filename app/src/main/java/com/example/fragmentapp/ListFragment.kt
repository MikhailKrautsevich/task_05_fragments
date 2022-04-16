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
        val v = inflater.inflate(R.layout.fragment_list, container, false)
        return v
    }

    private fun initViews() {
        textview1 = view?.findViewById(R.id.text_1)
        textview2 = view?.findViewById(R.id.text_2)
        textview3 = view?.findViewById(R.id.text_3)
        textview4 = view?.findViewById(R.id.text_4)
        textview5 = view?.findViewById(R.id.text_5)
        textview6 = view?.findViewById(R.id.text_6)

        textview1?.let { textViewsList.add(it) }
        textview2?.let { textViewsList.add(it) }
        textview3?.let { textViewsList.add(it) }
        textview4?.let { textViewsList.add(it) }
        textview5?.let { textViewsList.add(it) }
        textview6?.let { textViewsList.add(it) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        Log.d(LIST_FRAG_TAG, "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        setTexts()
        Log.d(LIST_FRAG_TAG, "onStart")
    }

    private fun setTexts() {
        for (textview in textViewsList) {
            textview.text = contactsList[textViewsList.indexOf(textview)].toString()
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
}