package br.applabbs.singlewebviewapp

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.applabbs.singlewebviewapp.Constants.URL_ENVIRONMENT
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //private val url = "https://mei.bradesco/pdpj-fed-mei-web/"
    private val urlEnvironment by lazy { intent?.getStringExtra(URL_ENVIRONMENT) }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = urlEnvironment
        supportActionBar?.setDisplayShowHomeEnabled(true)
        //setTitle(urlEnvironment)
        setUpWebView()
    }


    @JavascriptInterface
    fun showToast(s: String, t: String, u: String){
        Toast.makeText(this, "Name: $s | Age: $t | BankName: $u", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setUpWebView(){
        val webView = findViewById<WebView>(R.id.webView)
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setAppCachePath(cacheDir.path)

        settings.setSupportZoom(false)
        settings.builtInZoomControls = false
        settings.displayZoomControls = false

        settings.textZoom = 100
        settings.blockNetworkImage = false
        settings.loadsImagesAutomatically = true

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            settings.safeBrowsingEnabled = true
        }

        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.mediaPlaybackRequiresUserGesture = false

        // More optional settings, you can enable it by yourself
        settings.domStorageEnabled = true
        settings.setSupportMultipleWindows(true)
        settings.loadWithOverviewMode = true
        settings.allowContentAccess = true
        settings.setGeolocationEnabled(true)
        settings.allowUniversalAccessFromFileURLs = true
        settings.allowFileAccess = true

        // WebView settings
        webView.fitsSystemWindows = true
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)

        // Set web view client
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                loading.visibility = INVISIBLE
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                loading.visibility = VISIBLE
            }

            override fun onLoadResource(view: WebView, url: String) {
                super.onLoadResource(view, url)

            }

        }
        webView.loadUrl(urlEnvironment);

    }
}