package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.blakequ.rsa.FileEncryptionManager
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream
import java.io.File
import java.lang.Exception
import java.lang.RuntimeException
import java.security.*
import javax.crypto.Cipher
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.RSAPrivateKeySpec
import java.security.spec.RSAPublicKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.*
import java.math.BigInteger
import java.util.Random as Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment()  {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    //val publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDl1LC5LjUMjbH9tB4ODMBc7LZmRCaUuewkiGXlJzukeB3hcicM9bGFRnKNs9J1BdNFw6ww828Mn4HrdinJKrJIt+5eUz1J5M9vZJco9YDzyvlId0zPIHscOLazxNAG3qhtybYzYvmA25sdE84hTkYCYHz 7Ooklpssmw+hCWZhXQIDAQAB"

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
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    @SuppressLint("WrongThread")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val random = Random()
        val a = view.findViewById<ImageView>(R.id.imageView)

            val keyGen = KeyPairGenerator.getInstance("RSA")


            keyGen.initialize(1024)

            // Generate Key Pairs, a private key and a public key.
            val keyPair = keyGen.generateKeyPair()
            val privateKey = keyPair.private
            val publicKey = keyPair.public
            val encoder: java.util.Base64.Encoder = java.util.Base64.getEncoder()
            val m = encoder.encodeToString(privateKey.encoded)
            val l = encoder.encodeToString(publicKey.encoded)




        //val bitmap = (a.drawable as BitmapDrawable).bitmap

        //val byteArrayOutputStream = ByteArrayOutputStream()
       // bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        //val imageBytes: ByteArray = byteArrayOutputStream.toByteArray()
      //  val imageString: String = Base64.encodeToString(imageBytes, Base64.DEFAULT)


        val bm = (a.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos) // bm is the bitmap object

        val ba: ByteArray = baos.toByteArray()
        val encodedImage: String = Base64.encodeToString(ba, Base64.DEFAULT)
        val p = encodedImage.length

         Log.d("msg", "$p")
       // val p1 = BigInteger.probablePrime(1024, random)
       // val p2 = BigInteger.probablePrime(1024, random)
       // Log.d("prime","$p1 andddddddddddddddddddddddddddddddddddddddddddddddddddddddddd $p2")
        //val n = p1.multiply(p2)
        //val e = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAw9CoUJSKSKk53wVc1SBRu/z6a+7f9T+rvu1YMlP+vQQso2QzxMB2trpI1O3ShIRFXkPu+WLT9VV5Atnl/Omvg00Mr+lmp1znfgwiOyx7qjFFvgH06kOojDgc5U/x6BdRkKBYfX4KWecyPlaASKt5yWxbvEwNkIQ8T5KFG0zXN3JzjDH4ZK3W1BGt3jB1KU8OBfyD750WRu+qtyCm3gtj8s1SS3k8dcIdCrzJFJHtPsdnhLIqqV+c0h5HKIPJ54pxyNqmo+zgX2Cm4mx7X0Nk7yWXgg/6Js8mVhX9CWXS2me59c3EtsbqeNjEx15JF69fTypPMRFbzA84VOhy4yKIEe2H+fevWGvXBucH9q0mpG7jiiLe0wzi9YuywLNRzDdXCUmSdqd72Lt4sY3U/qS7MtsipVU//f/jcm603z+kz2nKrMqxf1JpnmT4gqe5SD2b9wHMaX39lp8Jwxh/Z7eFjzTlklvAoBQoX6gRYCJblgl1On0Z0yqk65DCPOIvQwa9C/APSEaH0tfB7KWEjLRrTEynaXEnOeH4BztgJXMYUEE3xnSJDQf/9/LGaAkiJIohaL5xmGWLLTbFqjbrfPhwipAycoQ37CUDUg8P0SNYr5BA9EtfKhD1Xuxj3iZISgrOiCRdlysEosg+xNU6oFmqIe1TRW3nKjIGt1aG4TaMS9UCAwEAAQ=="
        val xyz = ":*?b!finQgd+5=5p2,pgbc+a{f,Khu?_u)Gh}5&5aSVRUT=&Dik4(QU.eDkkkkkkkk{f75555555555555555555555555555555xbAie5/;iXw:bX7j\$"
        val oio = xyz.length
        Log.d("tag","$oio")
        fun encryption(data: String): String {
            var encoded = ""
            var encrypted: ByteArray? = null


                val publicBytes: ByteArray? = Base64.decode(l, Base64.DEFAULT)
                val keySpec: java.security.spec.X509EncodedKeySpec = java.security.spec.X509EncodedKeySpec(publicBytes)
                val keyFactory = KeyFactory.getInstance("RSA")
                val pubKey = keyFactory.generatePublic(keySpec)
                val cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING")
                cipher.init(Cipher.ENCRYPT_MODE, pubKey)
                encrypted = cipher.doFinal(xyz.toByteArray())
                encoded = Base64.encodeToString(encrypted, Base64.DEFAULT)
                    Log.d("final", encoded)


            return encoded

        }
        Log.d("RLreys", "$m privateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee   $l")
        encryption(xyz)









    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}