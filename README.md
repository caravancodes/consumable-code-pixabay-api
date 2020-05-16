# consumable-code-pixabay-api By AmirIsBack
- v1.0.1 - Development
- Stable Version

# About This Project
Eliminates the method of retrieving json data using retrofit repeatedly. so this project has a set of functions to retrieve data without the need for fetching data using the retrofit of the API

# Documentation Pixabay Api
https://pixabay.com/api/docs/

# Version Release
This Is Latest Release

    $version_release = 1.0.1

What's New??

    * add handing progress view and fully parameter *

# How To Use This Project
<h3>Step 1. Add the JitPack repository to your build file</h3>

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
<h3>Step 2. Add the dependency</h3>

	dependencies {
	        // library consumable code pixabay api
            implementation 'com.github.amirisback:consumable-code-pixabay-api:$version_release'
	}
	
<h3>Step 3. Declaration ConsumePixabayApi</h3>

    val consumePixabayApi = ConsumePixabayApi(PixabayConstant.SAMPLE_API_KEY) // Your API Key
    consumePixabayApi.usingChuckInterceptor(this) // Using Chuck Interceptor

    val query = "Nature"

    consumePixabayApi.searchImage(
        query,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        object : PixabayResultCallback<Response<PixabayImage>> {
            override fun getResultData(data: Response<PixabayImage>) {
                // Place your UI / Data
            }

            override fun failedResult(statusCode: Int, errorMessage: String?) {
                // failed to do
            }

            override fun onShowProgress() {
                // showing your progress view
            }

            override fun onHideProgress() {
                // hide your progress view
            }
        })
	
	
# Automatically Using This Permission
    
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

# Screen Shoot Apps
<span align="center"><img width="200px" height="360px" src="docs/image/ss_main.png"></span>
<span align="center"><img width="200px" height="360px" src="docs/image/ss_chuck_1.png"></span>
<span align="center"><img width="200px" height="360px" src="docs/image/ss_chuck_2.png"></span>

# Function Main From This Project
    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search for Image
    fun searchImage(
        q: String,
        lang: String?,
        id: String?,
        imageType: String?,
        orientation: String?,
        category: String?,
        minWidth: Int?,
        minHeight: Int?,
        colors: String?,
        editorsChoice: Boolean?,
        safeSearch: Boolean?,
        order: String?,
        page: Int?,
        perPage: Int?,
        callback: PixabayResultCallback<Response<PixabayImage>>
    )

    // Search for Video
    fun searchVideo(
        q: String,
        lang: String?,
        id: String?,
        videoType: String?,
        category: String?,
        minWidth: Int?,
        minHeight: Int?,
        editorsChoice: Boolean?,
        safeSearch: Boolean?,
        order: String?,
        page: Int?,
        perPage: Int?,
        callback: PixabayResultCallback<Response<PixabayVideo>>
    )

# Android Library Version (build.gradle)
- ext.kotlin_version = '1.3.70'
- classpath 'com.android.tools.build:gradle:3.6.1'
- compileSdkVersion 29
- buildToolsVersion "29.0.3"
- minSdkVersion 21

# Fecthing Data Library
- Retrofit
- RxJava
- OkHttp
- Chuck Interceptor

# Colaborator
Very open to anyone, I'll write your name under this, please contribute by sending an email to me

- Mail To faisalamircs@gmail.com
- Subject : Github _ [Github-Username-Account] _ [Language] _ [Repository-Name]
- Example : Github_amirisback_kotlin_admob-helper-implementation

Name Of Contribute
- Muhammad Faisal Amir
- Waiting List
- Waiting List

Waiting for your contribute

# Attention !!!
Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account
- If you like this library, please help me / you can donate to buy patreon services