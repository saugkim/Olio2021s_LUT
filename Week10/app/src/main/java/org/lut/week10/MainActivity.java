package org.lut.week10;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton refreshBtn, backBtn, forwardBtn;
    Button enterBtn, shoutBtn, initBtn, previousBtn, nextBtn;
    WebView webView;
    EditText editText;

    public static String DEFAULT = "https://www.lut.fi/";
    public static String URL = "file:///android_asset/index.html";
    String url = DEFAULT;

    String past = "";
    String next = "";
    Boolean isInBackward = false;

    ArrayList<String> visits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        enterBtn = findViewById(R.id.enterBtn);
        refreshBtn = findViewById(R.id.refreshBtn);
        shoutBtn = findViewById(R.id.shoutBtn);
        initBtn = findViewById(R.id.initBtn);
        webView = findViewById(R.id.webView);
        backBtn = findViewById(R.id.goBackBtn);
        forwardBtn = findViewById(R.id.goForwardBtn);
        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(DEFAULT);
        visits = new ArrayList<>();
        visits.add(url);
    }

    public void initialize(View v) {
        past = url;
        url = URL;

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:initialize()");
            }
        });
        webView.loadUrl(url);
    }

    public void shoutOut(View v) {
        past = url;
        url = URL;

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:shoutOut()");
            }
        });
        webView.loadUrl(url);
    }

    public void addToList(String url) {
        if (isInBackward) {
            visits.clear();
            isInBackward = false;
        }

        if (visits.size() == 10) {
            visits.remove(0);
        }

        visits.add(url);
    }

    public int getCurrentPosition(String url) {
        for (int i=0; i < visits.size() ; i++) {
            if (visits.get(i).equals(url)) {
                return i;
            }
        }
        return -1;
    }

    public void load(View v) {
        past = url;

        String input = editText.getText().toString();
        if (input.equals("index.html")) {
            url = URL;
        } else
            url = "https://" + input;

        addToList(url);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public void refreshView(View v) {
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        editText.setText(url);
    }

    public void goBackward(View v) {
        //if (webView.canGoBack()){
        //    webView.goBack();
        //}
        int idx = getCurrentPosition(url);
        if (idx >= 1) {
            url = visits.get(idx - 1);
            isInBackward = true;
        }
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public void goForward(View v) {
        //if (webView.canGoForward()) {
        //    webView.goForward();
        //}
        int idx = getCurrentPosition(url);
        if (idx < 9) {
            url = visits.get(idx+1);
        }
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public void goPrevious(View v) {
        if (past.trim().isEmpty()) {
            return;
        }
        next = url;
        url = past;
        editText.setText(url);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public void goNext(View v) {
        if (next.trim().isEmpty()) {
            return;
        }
        past = url;
        url = next;
        editText.setText(url);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}

//https://blog.eduonix.com/android-tutorials/learn-create-web-browser-application-using-android-studio/
//https://www.c-sharpcorner.com/article/create-web-browser-android-application-using-android-studio/