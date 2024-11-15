# Description of application:
1. Fetch data from the HN Algolia API https://hn.algolia.com/api/v1/search_by_date?query=mobile.
2. Display the fetched posts in a list with pull-to-refresh and swipe-to-delete functionality.
3. Store the data in a Room database and use Flow to observe data changes.
4. Navigate to a WebView when an item in the list is clicked.

## Stack Used
* Kotlin
* Jetpack Compose
* MVVM
* Room
* Retrofit
* Hilt
* Clean Architecture
