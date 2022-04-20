package com.example.fragmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class ListFragment : Fragment(R.layout.fragment_list) {

    private val contactsList: MutableList<ContactData> = ArrayList()
    private val textViewsList: MutableList<TextView> = ArrayList()

    private var haveSecondFragment = false

    private var textview1: TextView? = null
    private var textview2: TextView? = null
    private var textview3: TextView? = null
    private var textview4: TextView? = null
    private var textview5: TextView? = null
    private var textview6: TextView? = null

    companion object {
        private const val EXTRA_HAVE_SEC_FRAG = "EXHASEFR"
        const val REQUEST_KEY = "R_KEY"

        fun newListFragment(have: Boolean): ListFragment {
            val fragment = ListFragment()
            Bundle().let {
                it.putBoolean(EXTRA_HAVE_SEC_FRAG, have)
                fragment.arguments = it
            }
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContacts()
        arguments?.getBoolean(EXTRA_HAVE_SEC_FRAG)?.let {
            haveSecondFragment = it
        }

        setFragmentResultListener(REQUEST_KEY) { _, bundle ->
            val contactData = DetailFragment.getContactDataFromBundle(bundle)
            val position = DetailFragment.getPosition(bundle)
            contactsList[position] = contactData
            setText(position)
            setListener(position)
        }
    }

    private fun setListener(position: Int) {
        textViewsList[position].setOnClickListener(
            ContactListener(contactsList[position], position)
        )
    }

    private fun setText(position: Int) {
        textViewsList[position].text = contactsList[position].toString()
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

    override fun onStart() {
        super.onStart()
        setTexts()
        initListeners()
    }

    private fun setTexts() {
        for (i in 0 until textViewsList.size) {
            setText(i)
        }
    }

    private fun initListeners() {
        for (i in 0 until textViewsList.size) {
            setListener(i)
        }
    }

    inner class ContactListener(private val contactData: ContactData, private val position: Int) :
        View.OnClickListener {
        override fun onClick(p0: View?) {
            val fragment = DetailFragment.newDetailFragment(contactData, position)
            requireActivity().supportFragmentManager.beginTransaction().run {
                if (haveSecondFragment) {
                    replace(R.id.fragment_detail_container, fragment, "TAG")
                } else replace(R.id.fragment_container, fragment, "TAG")
                addToBackStack("TAG1")
                commit()
            }
        }
    }
}