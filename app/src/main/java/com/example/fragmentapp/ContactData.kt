package com.example.fragmentapp

data class ContactData(var name: String, var lastName: String, var number: String) {
    override fun toString(): String {
        return String.format("%s %s \n%s", name, lastName, number)
    }
}
