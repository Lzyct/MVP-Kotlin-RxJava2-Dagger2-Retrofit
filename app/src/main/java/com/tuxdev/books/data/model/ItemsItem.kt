package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class ItemsItem(
        val saleInfo: SaleInfo? = null,
        val searchInfo: SearchInfo? = null,
        val kind: String? = null,
        val volumeInfo: VolumeInfo? = null,
        val etag: String? = null,
        val id: String? = null,
        val accessInfo: AccessInfo? = null,
        val selfLink: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<SaleInfo>(SaleInfo::class.java.classLoader),
            source.readParcelable<SearchInfo>(SearchInfo::class.java.classLoader),
            source.readString(),
            source.readParcelable<VolumeInfo>(VolumeInfo::class.java.classLoader),
            source.readString(),
            source.readString(),
            source.readParcelable<AccessInfo>(AccessInfo::class.java.classLoader),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(saleInfo, 0)
        writeParcelable(searchInfo, 0)
        writeString(kind)
        writeParcelable(volumeInfo, 0)
        writeString(etag)
        writeString(id)
        writeParcelable(accessInfo, 0)
        writeString(selfLink)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ItemsItem> = object : Parcelable.Creator<ItemsItem> {
            override fun createFromParcel(source: Parcel): ItemsItem = ItemsItem(source)
            override fun newArray(size: Int): Array<ItemsItem?> = arrayOfNulls(size)
        }
    }
}


