package choongyul.android.com.rxandroid_study3network;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView cnet1, cnet2, nav1, nav2;
//    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnet1 = (TextView) findViewById(R.id.cnet1);
        cnet2 = (TextView) findViewById(R.id.cnet2);
        nav1 = (TextView) findViewById(R.id.nav1);
        nav2 = (TextView) findViewById(R.id.nav2);

//        button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(v -> {
//            // 버튼클릭시 io thread 실행하게 구현을 해볼까?
//        });

        // 여기서는 Rx android 2.0.1 이다.
        // Observable<String> 에서 제너릭으로 타입을 지정해주었다.
        Observable<String> naverObservable =
                Observable.create(emitter -> {
                    Remote.getUrlByGet("naver.com");
        });

        Observable<String> cnetObservable =
                Observable.create(emitter -> {
                    Remote.getUrlByGet("cnet.co.kr");
                });

    }
}