# Users 
Sample app to test the Room + paging architecture component.

This app uses the [Random.me API](https://randomuser.me) to generate a list of users.

As the focus of this app is just to test the integration between the paging component and Room, there is no error handling. Errors are simply logged.

![Users demo](/assets/users.gif)

## Libraries
* [Android Support Library](https://developer.android.com/topic/libraries/support-library/features)
* [Paging Library](https://developer.android.com/topic/libraries/architecture/paging/)
* [Data Binding Library](https://developer.android.com/topic/libraries/data-binding/)
* [ConstraintLayout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout)
* [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
* [Cardview](https://developer.android.com/guide/topics/ui/layout/cardview)
* [Retrofit2](https://square.github.io/retrofit/) for network requests
* [Moshi](https://github.com/square/moshi) for JSON parsing
* [Koin](https://insert-koin.io/) for dependency injection