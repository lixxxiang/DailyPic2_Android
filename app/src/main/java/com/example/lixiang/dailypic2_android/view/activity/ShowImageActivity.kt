package com.example.lixiang.dailypic2_android.view.activity

import android.Manifest
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.lixiang.dailypic2_android.R
import com.example.lixiang.dailypic2_android.util.ImgUtils
import kotlinx.android.synthetic.main.activity_show_image.*
import pub.devrel.easypermissions.EasyPermissions
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import android.os.StrictMode
import me.relex.photodraweeview.OnPhotoTapListener


class ShowImageActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>?) {
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build())
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build())
        setContentView(R.layout.activity_show_image)

        val url = intent.getStringExtra("imageUrl")
        image.setPhotoUri(Uri.parse(url))
        image.onPhotoTapListener = OnPhotoTapListener { _, _, _ ->
            finish()
        }
        save.setOnClickListener { requestPermission(url) }
    }

    private fun requestPermission(url: String) {
        if (Build.VERSION.SDK_INT >= 23) {
            val mPermissionList = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if (EasyPermissions.hasPermissions(this, *mPermissionList)) {
                saveImage(url)
            } else {
                EasyPermissions.requestPermissions(this, "保存图片需要读取sd卡的权限", 10, *mPermissionList)
            }
        } else {
            saveImage(url)
        }
    }

    private fun saveImage(url: String) {
        val bitmap = getbitmap(url)
        val isSaveSuccess = ImgUtils.saveImageToGallery(this, bitmap)
        if (isSaveSuccess) {
            Toast.makeText(this, "保存图片成功", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "保存图片失败，请稍后重试", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getbitmap(imageUri: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val myFileUrl = URL(imageUri)
            val conn = myFileUrl
                    .openConnection() as HttpURLConnection
            conn.doInput = true
            conn.connect()
            val `is` = conn.inputStream
            bitmap = BitmapFactory.decodeStream(`is`)
            `is`.close()

        } catch (e: OutOfMemoryError) {
            e.printStackTrace()
            bitmap = null
        } catch (e: IOException) {
            e.printStackTrace()
            bitmap = null
        }

        return bitmap
    }
}
