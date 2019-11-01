package com.example.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebViewMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebViewMain = findViewById(R.id.wv);
        //mWebViewMain.loadUrl("file:///android_asset/test.html");
        //load website
        mWebViewMain.getSettings().setJavaScriptEnabled(true);
        mWebViewMain.loadUrl("https:/m.baidu.com");
        mWebViewMain.setWebViewClient(new MyWebViewClient());
        mWebViewMain.setWebChromeClient(new MyWebChromeClient());
        //mWebViewMain.addJavascriptInterface();

    }
    class MyWebViewClient extends WebViewClient{
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        //load inside the page
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","onPageFinished...");
            mWebViewMain.loadUrl("javascript:alert('Hello')");
        }

    }
    class MyWebChromeClient extends WebChromeClient{
        @Override
        //progress of change like 0 to 100
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mWebViewMain.canGoBack()){
            mWebViewMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
