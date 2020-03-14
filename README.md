# consumable-code-pixabay-api By AmirIsBack
- v1.0.0 - Development
- Stable Version

# About This Project
Eliminates the method of retrieving json data using retrofit repeatedly. so this project has a set of functions to retrieve data without the need for fetching data using the retrofit of the API

# Special From This Project
Simple code and reusable data

# Fecthing Data Library
- Retrofit
- RxJava
- OkHttp
- Chuck Interceptor

# Documentation Pixabay Api
https://pixabay.com/api/docs/

# Function Main From This Project
    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search for Image
    fun searchImage(query: String, callback: PixabayResultCallback<ResponseImage>)

    // Search for Video
    fun searchVideo(query: String, callback: PixabayResultCallback<ResponseVideo>)

# Android Library Version (build.gradle)
- ext.kotlin_version = '1.3.70'
- classpath 'com.android.tools.build:gradle:3.6.1'
- compileSdkVersion 29
- buildToolsVersion "29.0.3"
- minSdkVersion 21

# Version Release
This Is Latest Release

    $version_release = 1.0.0

What's New??

    * New Release searchImage() and searchVideo() *

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

    val query = "One Piece"
    val consumePixabayApi = ConsumePixabayApi(PixabayConstant.SAMPLE_API_KEY)
    consumePixabayApi.usingChuckInterceptor(this)
    consumePixabayApi.searchImage(query, object : PixabayResultCallback<ResponseImage>{
        override fun getResultData(data: ResponseImage) {
            
            // * PLACE YOUR CODE HERE FOR UI / ARRAYLIST
            
        }

        override fun failedResult(statusCode: Int, errorMessage: String?) {
        }
    })
	
	

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