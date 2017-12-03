package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class OffersItem(
        val finskyOfferType: Int? = 0,
        val retailPrice: RetailPrice? = null,
        val listPrice: ListPrice? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readParcelable<RetailPrice>(RetailPrice::class.java.classLoader),
            source.readParcelable<ListPrice>(ListPrice::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(finskyOfferType!!)
        writeParcelable(retailPrice, 0)
        writeParcelable(listPrice, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OffersItem> = object : Parcelable.Creator<OffersItem> {
            override fun createFromParcel(source: Parcel): OffersItem = OffersItem(source)
            override fun newArray(size: Int): Array<OffersItem?> = arrayOfNulls(size)
        }
    }
}
