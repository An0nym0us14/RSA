package com.example.myapplication

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.blakequ.rsa.FileEncryptionManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import android.graphics.Bitmap

import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val b = view.findViewById<Button>(R.id.button)
        val mFileEncryptionManager: FileEncryptionManager = FileEncryptionManager.getInstance()
        val dat = "abc"
        val file = File.createTempFile(dat, ".jpeg")
        b.setOnClickListener {
            mFileEncryptionManager.generateKey()
            val x = mFileEncryptionManager.privateKey
            val y = mFileEncryptionManager.publicKey
            android.util.Log.d("tag", "$x and $y")


            val data: ByteArray =
                com.blakequ.rsa.FileUtils.getBytesFromInputStream(resources.openRawResource(R.drawable.download))

            android.util.Log.d("tag", "$data")
            val result = mFileEncryptionManager.encryptFileByPublicKey(data, file)

            val storageReference = FirebaseStorage.getInstance().getReference("image/")


            storageReference.putFile(Uri.fromFile(file))
        }
        val c =view.findViewById<Button>(R.id.button2)
        c.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_blankFragment2)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}