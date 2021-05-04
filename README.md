# Marvel App
The Marvel App provides users with a list of characters of Marvel universe. The data shown in the app is retrieved from the Marvel API. 

# Project Technology
- MVVM
- Kotlin
- Flow (Coroutines)
- Navigation Component
- Dagger Hilt DI
- Data Binding

# Architecture Design
The Project follows a MVVM with Repository pattern architecture. This architecture was chosen for:
- Separation of Concerns that provides a way to testing the architecture components in isolation and allows for the View classes to be updated without modifying the ViewModel classes.
- Resilience to configuration changes allows the ViewModel classes to store UI data that would otherwise be lost on screen rotation or activity lifecycle changes.
- Communication between fragments using a ViewModel class removes the need for fragments to communicate via an Activity using callbacks.

The View classes use data binding to communicate updates to their respective ViewModel classes. The ViewModel classes communicate with a Repository class using coroutines and receives responses using LiveData. This is then passed back to the View classes observing this LiveData. The Repository class communicates with a RESTful API using Retrofit and caches the response to a local Room database.

# Test Cases

# Libraries Used
- Dagger Hilt to provide constructor dependency injection to classes in the application
- Retrofit to provide access to the backend API endpoints
- Coroutines to run API network requests on background threads
- AndroidX to provide Lifecycle and LiveData functionality to the app
- Data binding to bind the inflated layout files to instances running in the application code.

# Further Improvements
- Refactor project to use Pagination 3 that has been developed with Kotlin coroutines in mind.
- Refactor to cache data in Room DB.
- Refactor and add workmanager to retrieve data from API in the background.
