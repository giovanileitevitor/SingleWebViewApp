package br.applabbs.singlewebviewapp

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //webView.loadUrl("https://www.google.com")
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(this, "testing")
        webView.loadUrl("file:///android_asset/webview.html")
//        webView.webViewClient = object : WebViewClient(){
//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                view.loadUrl(url)
//                return false
//            }
//
//            @TargetApi(Build.VERSION_CODES.N)
//            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
//                view.loadUrl(request.url.toString())
//                return false
//            }
//        }
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
}