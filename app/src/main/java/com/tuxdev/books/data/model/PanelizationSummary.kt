package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class PanelizationSummary(
		val containsImageBubbles: Boolean? = null,
		val containsEpubBubbles: Boolean? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readValue(Boolean::class.java.classLoader) as Boolean?,
			source.readValue(Boolean::class.java.classLoader) as Boolean?
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(containsImageBubbles)
		writeValue(containsEpubBubbles)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<PanelizationSummary> = object : Parcelable.Creator<PanelizationSummary> {
			override fun createFromParcel(source: Parcel): PanelizationSummary = PanelizationSummary(source)
			override fun newArray(size: Int): Array<PanelizationSummary?> = arrayOfNulls(size)
		}
	}
}
