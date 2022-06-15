# RecyclerView

## Buat Data Class yang menampung data President
``` Ruby
@Parcelize
data class PresidentModel(
    val poster: String,
    val name: String,
    val desc: String
): Parcelable
end
```
