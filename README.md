Project description
----

Showcase-cryptocurrency it's a sample project to demonstrate how a clean architecure app could be.
The goal of the project is to demonstrate good practices, provide a set of guidelines, and present modern Android application architecture that is modular, scalable, maintainable and testable that is the most important when you develop and app.


Project caracteristics
----
* [Dagger2](https://github.com/google/dagger)  --> For dependency injection<br/>
* [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) --> For reactive programming<br/>
* [Retrofit](https://github.com/square/retrofit) --> To do API calls <br/>
* [Gson](https://github.com/google/gson) --> To parse the results from Retrofit <br/>
* [Glide](https://github.com/bumptech/glide) --> Image loader <br/>
* [MockK](https://github.com/mockk/mockk) --> For testing purposes <br/>
* [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) --> For integration tests
* [Espresso](https://developer.android.com/training/testing/espresso/setup) --> For UI tests

How is done
-----

This app is developed following this image of **clean architecture** <br/>
![CleanArch](https://miro.medium.com/max/700/0*sfCDEb571WD-7EfP.jpg)

I'm following the **MVP pattern** <br/>
![MVPPattern](https://grapecitycontentcdn.azureedge.net/blogs/legacy/xuni/2016/05/MVP1.png)

Each layer has a distinct set of responsibilities:
- `Presentation layer` - presents data to a screen and handle user interactions
- `Domain layer` - contains business logic
- `Data layer` - access, retrieve and manage application data

There's different modules

* buildSrc(Kotlin + buildSrc) --> To have well organised all of the libraries of the project
* app --> Contains all of the Application and all the setup for the Dagger
* library_base --> It contains all of the core of the application
* networking --> It contains in this case the `Retrofit` module with all the interceptors like `ErrorInterceptor`, `HeaderInterceptor`
* cryptos --> It's a feature module, where contains the list and the detail of the cryptos.

## Getting started

There are a few ways to open this project.

### Android Studio

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/joancolmenerodev/showcase-cryptocurrency.git` into URL field

### Command line + Android Studio

1. Run `git clone https://github.com/joancolmenerodev/showcase-cryptocurrency.git`
2. Android Studio -> File -> Open

Once it's opened you can run the app, but I recommend to you to create a new [API KEY](https://pro.coinmarketcap.com/signup) so you don't waste all of my free usages.

### Running tests

`./gradlew test`







