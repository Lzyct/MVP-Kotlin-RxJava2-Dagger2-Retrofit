package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class RetailPrice(
		val amount: Int? = null,
		val currencyCode: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readValue(Int::class.java.classLoader) as Int?,
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(amount)
		writeString(currencyCode)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<RetailPrice> = object : Parcelable.Creator<RetailPrice> {
			override fun createFromParcel(source: Parcel): RetailPrice = RetailPrice(source)
			override fun newArray(size: Int): Array<RetailPrice?> = arrayOfNulls(size)
		}
	}
}
