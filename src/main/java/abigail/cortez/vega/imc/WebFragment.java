package abigail.cortez.vega.imc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebFragment extends Fragment {
WebView webView;

    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaPrincipal=inflater.inflate(R.layout.fragment_web, container, false);
       //instanciar
        webView =(WebView) vistaPrincipal.findViewById(R.id.wvImc);
        //para mandar a una url
        String url="https://www.cdc.gov/healthyweight/spanish/assessing/bmi/index.html";
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return vistaPrincipal ;
    }

}
