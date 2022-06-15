# RecyclerView

#### Buat Data Class yang menampung data President
``` Ruby
@Parcelize
data class PresidentModel(
    val poster: String,
    val name: String,
    val desc: String
): Parcelable
```

#### Ubah kode pada layout activity_main
``` Ruby
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_presidents"
        android:layout_width="@dimen/dp_0"
        android:layout_height="@dimen/dp_0"
        app:layout_constraintTop_toTopOf="parent"
        android:padding="@dimen/dp_8"
        android:clipToPadding="false"
        tools:listitem="@layout/item_list_president"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### Buat activity baru dengan nama DetailActivity.kt dan ubah kode pada layout activity_detail
``` Ruby
<?xml version="1.0" encoding="utf-8"?>
<androidx.core.widget.NestedScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true"
    tools:context=".DetailActivity">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <ImageView
            android:id="@+id/img_poster"
            android:layout_width="match_parent"
            android:layout_height="@dimen/dp_450"
            android:scaleType="centerCrop"
            android:src="@android:color/darker_gray"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            tools:ignore="ContentDescription" />

        <TextView
            android:id="@+id/tv_name"
            android:layout_width="@dimen/dp_0"
            android:layout_height="wrap_content"
            android:layout_marginStart="@dimen/dp_16"
            android:layout_marginEnd="@dimen/dp_16"
            tools:text="Nur Muhammad Syaifuddin"
            android:textSize="@dimen/sp_18"
            android:textColor="@color/black"
            android:textStyle="bold"
            android:layout_marginTop="@dimen/dp_32"
            app:layout_constraintTop_toBottomOf="@id/img_poster"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"/>

        <TextView
            android:id="@+id/tv_desc"
            android:layout_width="@dimen/dp_0"
            android:layout_height="wrap_content"
            android:layout_marginTop="@dimen/dp_16"
            android:layout_marginBottom="@dimen/dp_32"
            android:lineSpacingExtra="@dimen/dp_4"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="@id/tv_name"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="@id/tv_name"
            app:layout_constraintTop_toBottomOf="@id/tv_name"
            app:layout_constraintVertical_bias="0.0"
            tools:text="@tools:sample/lorem/random" />

    </androidx.constraintlayout.widget.ConstraintLayout>

</androidx.core.widget.NestedScrollView>
```
