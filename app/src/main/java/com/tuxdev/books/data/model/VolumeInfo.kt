package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class VolumeInfo(
        val industryIdentifiers: List<IndustryIdentifiersItem?>? = null,
        val pageCount: Int? = null,
        val printType: String? = null,
        val readingModes: ReadingModes? = null,
        val previewLink: String? = null,
        val canonicalVolumeLink: String? = null,
        val description: String? = null,
        val language: String? = null,
        val title: String? = null,
        val subtitle: String? = null,
        val imageLinks: ImageLinks? = null,
        val panelizationSummary: PanelizationSummary? = null,
        val publisher: String? = null,
        val publishedDate: String? = null,
        val categories: List<String>? = null,
        val maturityRating: String? = null,
        val allowAnonLogging: Boolean? = null,
        val contentVersion: String? = null,
        val authors: List<String>? = null,
        val infoLink: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(IndustryIdentifiersItem.CREATOR),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readParcelable<ReadingModes>(ReadingModes::class.java.classLoader),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readParcelable<ImageLinks>(ImageLinks::class.java.classLoader),
            source.readParcelable<PanelizationSummary>(PanelizationSummary::class.java.classLoader),
            source.readString(),
            source.readString(),
            source.createStringArrayList(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.createStringArrayList(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(industryIdentifiers)
        writeValue(pageCount)
        writeString(printType)
        writeParcelable(readingModes, 0)
        writeString(previewLink)
        writeString(canonicalVolumeLink)
        writeString(description)
        writeString(language)
        writeString(title)
        writeString(subtitle)
        writeParcelable(imageLinks, 0)
        writeParcelable(panelizationSummary, 0)
        writeString(publisher)
        writeString(publishedDate)
        writeStringList(categories)
        writeString(maturityRating)
        writeValue(allowAnonLogging)
        writeString(contentVersion)
        writeStringList(authors)
        writeString(infoLink)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<VolumeInfo> = object : Parcelable.Creator<VolumeInfo> {
            override fun createFromParcel(source: Parcel): VolumeInfo = VolumeInfo(source)
            override fun newArray(size: Int): Array<VolumeInfo?> = arrayOfNulls(size)
        }
    }
}
