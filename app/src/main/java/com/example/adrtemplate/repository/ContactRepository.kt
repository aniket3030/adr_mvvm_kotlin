package com.example.adrtemplate.repository

import androidx.lifecycle.LiveData
import com.example.adrtemplate.database.AppDatabase
import com.example.adrtemplate.database.entity.Contact

class ContactRepository(private val database: AppDatabase) {

    private val dao = database.getContactDao()

    suspend fun insertContact (contact: Contact) = dao.insertContact(contact = contact)

    suspend fun updateContact  (contact: Contact) = dao.updateContact(contact = contact)

    suspend fun deleteContact  (contact: Contact) = dao.deleteContact(contact = contact)

    fun getContacts () : LiveData<List<Contact>> = dao.getContacts()
}