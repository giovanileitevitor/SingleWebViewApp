package br.applabbs.singlewebviewapp

import android.webkit.WebView
import br.applabbs.singlewebviewapp.ui.main.MainActivity
import org.junit.Test
import org.junit.Assert.*

class MainActivityTest {

    @Test
    fun should_set_the_correct_settings_of_the_WebView() {

        val requestedUrl = "https://www.google.com"
        var resultUrl: String? = null

        // Arrange the webView
        val webView = WebView(MainActivity.application.baseContext)

        // Act by calling the setPageStatus
        webFragment.setPageStatus(webView) { pageStatusResult ->
            when (pageStatusResult) {
                is PageStatusResult.PageStarted -> {
                    resultUrl = pageStatusResult.url
                }
            }
        }

        // trying to load the "requestedUrl"
        webView.loadUrl(requestedUrl)

        // waiting until the "onPageStarted" is called
        await().until { resultUrl != null }

        // now check the equality of URLs
        assertThat(resultUrl).isEqualToIgnoringCase(requestedUrl)
    }
}