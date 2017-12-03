package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class SaleInfo(
        val offers: List<OffersItem>? = null,
        val country: String? = null,
        val isEbook: Boolean? = null,
        val saleability: String? = null,
        val buyLink: String? = null,
        val retailPrice: RetailPrice? = null,
        val listPrice: ListPrice? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            ArrayList<OffersItem>().apply { source.readList(this, OffersItem::class.java.classLoader) },
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readString(),
            source.readParcelable<RetailPrice>(RetailPrice::class.java.classLoader),
            source.readParcelable<ListPrice>(ListPrice::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(offers)
        writeString(country)
        writeValue(isEbook)
        writeString(saleability)
        writeString(buyLink)
        writeParcelable(retailPrice, 0)
        writeParcelable(listPrice, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SaleInfo> = object : Parcelable.Creator<SaleInfo> {
            override fun createFromParcel(source: Parcel): SaleInfo = SaleInfo(source)
            override fun newArray(size: Int): Array<SaleInfo?> = arrayOfNulls(size)
        }
    }
}