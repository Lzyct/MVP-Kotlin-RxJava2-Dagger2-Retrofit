package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class DataBooks(
        val totalItems: Int? = null,
        val kind: String? = null,
        val items: List<ItemsItem>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            ArrayList<ItemsItem>().apply { source.readList(this, ItemsItem::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(totalItems)
        writeString(kind)
        writeList(items)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<DataBooks> = object : Parcelable.Creator<DataBooks> {
            override fun createFromParcel(source: Parcel): DataBooks = DataBooks(source)
            override fun newArray(size: Int): Array<DataBooks?> = arrayOfNulls(size)
        }
    }
}
