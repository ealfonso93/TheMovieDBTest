# LetGo Android challenge

## Architecture

##### Kotlin
There is no Java trace on this project, all parts have been developed using Kotlin and trying to use as much of it's features as possible.

##### Activity or fragment?
No fragments have been used for this project, only one activity containing the list, since it didn't seem worth the overhead and anyway an activity was needed to contain the fragment.

##### MVVM
The chosen pattern has been an [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) approach, since Google it's really pushing for it with its architecture components.

##### LiveData
LiveData has been chosen for this project since one of it's greatest feature is being "lifecycle aware" and therefore no need on keeping track of subscribing and unsubscribing.

##### Repository pattern
 Repository pattern is used to be able to quickly "swap" the datasource if necessary (even though now it only loads the content from a server API) and to make it as testable as possible.
 
##### Dependency injection
Any class dependency is injected using dagger.

##### UI Components
- Databinding: Used to easily deal with setting "properties" to the UI components (text, images, etc), for this list the ViewModel itself is passed, so if it were necessary to set properties to a new View of the list item could be easily done.
- Cardview: Used for each list item to give that "card" (as the library name suggests) look.
- RecyclerView: This View holds all items and display them, also it's "relatively" easy to append items for the lazy load.
- Constraintlayout: Used for each RecyclerView item to be able to have a strong looking UI (say goodbye to RelativeLayout and nested LinearLayouts).
- [BaseRecyclerViewAdapter](https://github.com/skydoves/BaseRecyclerViewAdapter): Library to heal deal with the RecyclerView lazy load and adapter itself.
- Glide: Library to help loading images from a url (even though it can do much more it's only used to deal with that here)

##### Testing
- JUnit: Very popular and useful library to test anything Java related
- Espresso: Library to help with UI testing
- [MockitoKotlin](https://github.com/nhaarman/mockito-kotlin): Similar library to mockito but made for Kotlin, since mockito doesn't always play well with Kotlin
- MockWebserver: Great helper library to mock server responses

