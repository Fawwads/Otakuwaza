package com.fawwad.otakuwaza.repository

import android.util.Log
import com.fawwad.otakuwaza.repository.DatabaseConstants.COLLECTIONS
import com.fawwad.otakuwaza.repository.model.Character
import com.fawwad.otakuwaza.repository.model.Collection
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DatabaseHelper {

    val TAG = "DatabaseHelper"

    val db = Firebase.firestore

    fun addCollection(collection: Collection) {

        db.collection(COLLECTIONS).add(collection)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

    }

    fun getAllCollections(responseCallback: ResponseCallback<List<Collection>>){
        db.collection(COLLECTIONS).get()
            .addOnSuccessListener { result ->
                var collections = arrayListOf<Collection>()
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                responseCallback.onFailure(exception)
            }
    }

}