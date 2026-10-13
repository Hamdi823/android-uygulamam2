package com.example.webapp

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.KeyEvent

class MainActivity : Activity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        webView = WebView(this).apply {
            // Siteyi dış tarayıcıda değil, uygulamanın içinde açar
            webViewClient = WebViewClient() 
            // Sitenin düzgün çalışması için JavaScript'i aktif ediyoruz
            settings.javaScriptEnabled = true 
            settings.domStorageEnabled = true
            
            // WEB SİTESİ KODUNUZ BURAYA GELECEK
            // 3 tırnak (""") işaretleri arasına elinizdeki HTML kodunu yapıştırabilirsiniz.
            // Örnek bir tasarım ekledim, siz burayı kendi kodunuzla değiştirebilirsiniz:
            val htmlKodu = """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <style>
                        body { font-family: sans-serif; text-align: center; margin-top: 50px; background-color: #f4f4f9; color: #333; }
                        h1 { color: #2c3e50; }
                        p { font-size: 18px; color: #555; padding: 20px; }
                        .btn { background: #3498db; color: white; padding: 12px 24px; text-decoration: none; border-radius: 8px; font-weight: bold; }
                    </style>
                </head>
                <body>
                    <h1>Hoş Geldiniz!</h1>
                    <p>Mobil uygulamamız başarıyla çalışıyor.</p>
                </body>
                </html>
            """
            
            loadDataWithBaseURL(null, htmlKodu, "text/html", "UTF-8", null)
            
            // NOT: EĞER SİTENİZ ZATEN İNTERNETTE YAYINDAYSA (örn: www.sitem.com)
            // ÜSTTEKİ HTML KISMINI SİLİP SADECE ŞU KODU KULLANABİLİRSİNİZ:
            // loadUrl("https://www.sizin-siteniz.com")
        }
        
        setContentView(webView)
    }
    
    // Telefonun geri tuşuna basıldığında uygulamayı kapatmak yerine sitede bir önceki sayfaya dönmeyi sağlar
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
