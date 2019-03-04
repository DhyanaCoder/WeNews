package com.example.thinkpad.wenews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static com.example.thinkpad.wenews.MainActivity.progressDialog;

public class ContentWebview extends AppCompatActivity {
    private TextView text_title,text_info,text_content;
    String title=new String();
    String author=new String();
    String time=new String() ;
    String imgAdress=new String();
    ProgressDialog progressDialog ;
    StringBuffer buffer=new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_webview);
        Intent intent=getIntent();
        String address=intent.getStringExtra("address");

        WebView webView=(WebView) findViewById(R.id.web_view);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //支持缩放

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(address);
       /* text_title=(TextView)findViewById(R.id.title);
        text_info=(TextView)findViewById(R.id.author_time);
        text_content=(TextView)findViewById(R.id.content);
       crawler(address);*/
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
            actionBar.hide();
        ImageButton button=(ImageButton)findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void crawler( final String href ){
        //   String text=null;
        new Thread() {
            @Override
            public void run() {

                super.run();
                try {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.show();
                        }
                    });

                    Document doc = Jsoup.connect(href).get();
                    Log.d("12345",doc.html());
                    Log.d("kh1",""+href);


                    Element head=doc.select("p").first();
                    Log.d("head",""+head.text());
                    title=head.select("h1.title").first().text();
                    author =head.select("span.author").first().text();
                    time =head.select("span.time.js-time").first().text();
                    imgAdress=doc.getElementsByTag("a[href]").first().attr("href");
                    Log.d("bhk123",title);
                    Log.d("img",imgAdress);
                    Element content=doc.select("div.content.fontsmall").first();
                    Log.d("bhk456",content.text());
                    Elements paragraphs=content.select("p");
                    buffer.append("\n");
                    for(Element para:paragraphs){
                        buffer.append("     "+para.text()+"\n\n");
                        Log.d("p_p",para.text());
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text_title.setText("    "+title);
                            text_info.setText("  来源："+author+" 时间："+time);
                            text_content.setText(buffer);
                            progressDialog.dismiss();
                        }
                    });


                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
