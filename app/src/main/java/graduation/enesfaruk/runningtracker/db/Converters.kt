package graduation.enesfaruk.runningtracker.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

/**
 * Created by Enes Faruk Işık on 19.03.2022.
 */
class Converters {

    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap{
        return BitmapFactory.decodeByteArray(bytes,0,bytes.size)
    }

    @TypeConverter
    fun fromBitmap(bmp: Bitmap): ByteArray{
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG,100,outputStream)
        return outputStream.toByteArray()
    }
}